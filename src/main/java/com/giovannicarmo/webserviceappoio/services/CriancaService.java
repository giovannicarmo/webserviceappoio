package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.domain.enums.CategoriaTea;
import com.giovannicarmo.webserviceappoio.domain.enums.Sexo;
import com.giovannicarmo.webserviceappoio.dto.CriancaNewDTO;
import com.giovannicarmo.webserviceappoio.repositories.CriancaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
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

    public List<Crianca> criancaUsuario(Integer id_usuario) {
        return repository.criancaUsuario(id_usuario);
    }

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

    public Crianca insert(Crianca object) {
        object.setId(null);
        return repository.save(object);
    }

    public Crianca update(Crianca object) {
        return repository.save(object );
    }

    public void delete(Integer id) {
        find(id);
        try{
            repository.delete(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Nao pode ser excluido pois esta relacionado com outras entidades");
        }
    }

    public Crianca fromDTO (CriancaNewDTO objectDTO) {
        Crianca object = new Crianca(null, objectDTO.getNome(), objectDTO.getColegio(),
                objectDTO.getDataNascimento(), Sexo.toEnum(objectDTO.getSexo()),
                CategoriaTea.toEnum(objectDTO.getCategoriaTea()));
        return object;
    }

//    private Crianca updateData(Crianca object) {
//        Crianca newObject = find(object.getId());
//        newObject.setNome(object.getNome());
//        newObject.setColegio(object.getColegio());
//        newObject.setDataNascimento(object.getDataNascimento());
//        newObject.setSexo(object.getSexo());
//        newObject.setCategoriaTea(object.getCategoriaTea());
//        newObject.setUsuarios(object.getUsuarios());
//        return newObject;
//    }

    public URI uploadCriancaPicture(Integer id, MultipartFile multipartFile) {

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
