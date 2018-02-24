package com.giovannicarmo.webserviceappoio.services;


import com.giovannicarmo.webserviceappoio.domain.MensagemUsuario;
import com.giovannicarmo.webserviceappoio.domain.MensagemUsuarioPK;
import com.giovannicarmo.webserviceappoio.repositories.MensagemUsuarioRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemUsuarioService {

    @Autowired
    private MensagemUsuarioRepository repository;

    public List<MensagemUsuario> findAll(){
        return repository.findAll();
    }

    public MensagemUsuario find(MensagemUsuarioPK id) {
        MensagemUsuario object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + MensagemUsuario.class.getName());
        }
        return object;
    }

    public MensagemUsuario insert(MensagemUsuario object) {
        object.setId(null);
        return repository.save(object);
    }

    public void delete(MensagemUsuarioPK id) {
        find(id);
        try{
            repository.delete(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Nao pode ser excluido pois esta relacionado com outras entidades");
        }
    }
}
