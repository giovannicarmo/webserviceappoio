package com.giovannicarmo.webserviceappoio.services;
import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Usuario save(Usuario object) {
        repository.save(object);
        return object;
    }

    public Usuario update(Integer id, Usuario object) {
        object = find(id);
        repository.save(object);
        return object;
    }

    public Usuario delete(Integer id) {
        Usuario object = find(id);
        repository.delete(object);
        return object;
    }
}
