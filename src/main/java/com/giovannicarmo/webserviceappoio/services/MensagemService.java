package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Mensagem;
import com.giovannicarmo.webserviceappoio.repositories.MensagemRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository repository;

    public List<Mensagem> findAll(){
        return repository.findAll();
    }

    public Mensagem find(Integer id) {
        Mensagem object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Mensagem.class.getName());
        }
        return object;
    }

    public Mensagem save(Mensagem object) {
        repository.save(object);
        return object;
    }

    public Mensagem update(Integer id, Mensagem object) {
        object = find(id);
        repository.save(object);
        return object;
    }

    public Mensagem delete(Integer id) {
        Mensagem object = find(id);
        repository.delete(object);
        return object;
    }
}
