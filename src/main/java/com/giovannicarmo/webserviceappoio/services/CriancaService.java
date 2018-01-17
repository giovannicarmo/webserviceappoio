package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.repositories.CriancaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriancaService {

    @Autowired
    private CriancaRepository repository;

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

    public Crianca save(Crianca object) {
        repository.save(object);
        return object;
    }

    public Crianca delete(Integer id) {
        Crianca object = find(id);
        repository.delete(object);
        return object;
    }
}
