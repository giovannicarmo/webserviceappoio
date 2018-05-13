package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.repositories.CriancaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.AuthorizationExcepition;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;

@Service
public class CriancaService {

    @Autowired
    private CriancaRepository repository;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.crianca.profile}")
    private String prefix;

    @Value("${image.profile.size}")
    private Integer size;

    public List<Crianca> findAll(){
        return repository.findAll();
    }

    public Crianca find(Integer id) {
        Crianca object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Crianca.class.getName());
        }
        return object;
    }

    public List<Crianca> findByUsuario(Integer id) {
        List <Crianca> object = repository.findCriancaByUsuario(id);
        if(object == null) {
            throw new ObjectNotFoundException("Usuário inexistente ou não vinculado com nenhuma criança!");
        }

        return object;
    }

    public Crianca insert(Crianca object) {
        object.setId(null);
        return repository.save(object);
    }

    public Crianca update(Crianca object) {
        return repository.save(object);
    }

    public void delete(Integer id) {
        find(id);
        try{
            repository.delete(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Nao pode ser excluido pois esta relacionado com outras entidades");
        }
    }

    public URI uploadPicture(Integer id, MultipartFile multipartFile) {

        Crianca object = repository.findOne(id);
            if(object == null) {
                throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Crianca.class.getName());
            }

        BufferedImage jpgImage = imageService.getJpjImageFromFile(multipartFile);
        jpgImage = imageService.cropSquare(jpgImage);
        jpgImage = imageService.resize(jpgImage, size);

        String fileName = prefix + object.getId() + ".jpg";

        return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
    }
}
