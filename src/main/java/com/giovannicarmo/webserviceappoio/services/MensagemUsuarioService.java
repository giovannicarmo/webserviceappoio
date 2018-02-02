package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.MensagemUsuario;
import com.giovannicarmo.webserviceappoio.repositories.MensagemUsuarioRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemUsuarioService {

    @Autowired
    private MensagemUsuarioRepository repository;

    public List<MensagemUsuario> findAll(){
        return repository.findAll();
    }

    public MensagemUsuario find(Integer id) {
        MensagemUsuario object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + MensagemUsuario.class.getName());
        }
        return object;
    }

    public MensagemUsuario save(MensagemUsuario object) {
        repository.save(object);
        return object;
    }

    public MensagemUsuario delete(Integer id) {
        MensagemUsuario object = find(id);
        repository.delete(object);
        return object;
    }
}
