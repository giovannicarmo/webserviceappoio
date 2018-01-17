package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Rotina;
import com.giovannicarmo.webserviceappoio.repositories.RotinaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotinaService {

    @Autowired
    private RotinaRepository repository;

    public List<Rotina> findAll(){
        return repository.findAll();
    }

    public Rotina find(Integer id) {
        Rotina object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Rotina.class.getName());
        }
        return object;
    }

    public Rotina save(Rotina object) {
        repository.save(object);
        return object;
    }

    public Rotina delete(Integer id) {
        Rotina object = find(id);
        repository.delete(object);
        return object;
    }
}
