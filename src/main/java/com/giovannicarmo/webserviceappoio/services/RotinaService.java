package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Rotina;
import com.giovannicarmo.webserviceappoio.repositories.RotinaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RotinaService {

    @Autowired
    private RotinaRepository repository;

    public Rotina find (Integer id) {
        Rotina rotina = repository.findOne(id);
        if(rotina == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Rotina.class.getName());
        }
        return rotina;
    }
}
