package com.giovannicarmo.webserviceappoio.services;
import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

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

    public Page<Usuario> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
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

    private void updateData(Usuario newObject, Usuario object) {
        newObject.setNome(object.getNome());
        newObject.setEmail(object.getEmail());
        newObject.setSenha(object.getSenha());
        newObject.setTelefone(object.getTelefone());
        newObject.setFoto(object.getFoto());
        newObject.setTipo(object.getTipo());
    }
}
