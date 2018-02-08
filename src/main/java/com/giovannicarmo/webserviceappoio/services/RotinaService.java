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
}
