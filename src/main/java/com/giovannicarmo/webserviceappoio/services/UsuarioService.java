package com.giovannicarmo.webserviceappoio.services;
import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.dto.UsuarioNewDTO;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;
import com.giovannicarmo.webserviceappoio.dto.UsuarioUpdateDTO;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import com.giovannicarmo.webserviceappoio.security.UserSS;
import com.giovannicarmo.webserviceappoio.services.excepition.AuthorizationExcepition;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.usuario.profile}")
    private String prefix;

    @Value("${image.profile.size}")
    private Integer size;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario find(Integer id) {
        Usuario object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Usuario.class.getName());
        }
        return object;
    }

    public Usuario findByEmail(String email) {
        Usuario object = repository.findByEmail(email);
        if (object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Email: " + email + "Tipo: " + Usuario.class.getName());
        }
            return object;
    }

    public Usuario insert(Usuario object) {
        object.setId(null);
        return repository.save(object);
    }

    public Usuario update(Usuario object) {
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

    public Usuario fromDTO(UsuarioNewDTO objectDTO) {
        Usuario usuario = new Usuario(objectDTO.getNome(), objectDTO.getEmail(),
                passwordEncoder.encode(objectDTO.getSenha()), objectDTO.getTelefone(),
                TipoUsuario.toEnum(objectDTO.getTipo()));
        return usuario;
    }

    public Usuario fromUpdateDTO(UsuarioUpdateDTO objectDTO) {
        Usuario usuario = new Usuario(objectDTO.getNome(), null,
                passwordEncoder.encode(objectDTO.getSenha()), objectDTO.getTelefone(),
                null);
        return usuario;
    }

    public URI uploadProfilePicture(MultipartFile multipartFile) {

        UserSS userSS = UserService.authenticated();
        if (userSS == null) {
            throw new AuthorizationExcepition("Access denied!");
        }

        BufferedImage jpgImage = imageService.getJpjImageFromFile(multipartFile);
        jpgImage = imageService.cropSquare(jpgImage);
        jpgImage = imageService.resize(jpgImage, size);

        String fileName = prefix + userSS.getId() + ".jpg";

        return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
    }
}
