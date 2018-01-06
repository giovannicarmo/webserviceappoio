package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.repositories.CriancaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriancaService {

    @Autowired
    private CriancaRepository repository;

    public Crianca find (Integer id) {
        Crianca crianca = repository.findOne(id);
        if(crianca == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Crianca.class.getName());
        }
        return crianca;
    }
}
