package com.giovannicarmo.webserviceappoio.services;
import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.dto.UsuarioNewDTO;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

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

    public Usuario insert(Usuario object) {
        object.setId(null);
        return repository.save(object);
    }

    public Usuario update(Usuario object) {
        Usuario newObject = find(object.getId());
        updateData(newObject, object);
        return repository.save(newObject);
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
                objectDTO.getFoto(), TipoUsuario.toEnum(objectDTO.getTipo()));
        return usuario;
    }

    private void updateData(Usuario newObject, Usuario object) {
        newObject.setNome(object.getNome());
        newObject.setEmail(object.getEmail());
        newObject.setSenha(object.getSenha());
        newObject.setTelefone(object.getTelefone());
        newObject.setFoto(object.getFoto());
        newObject.setTipo(object.getTipo());
    }
}
