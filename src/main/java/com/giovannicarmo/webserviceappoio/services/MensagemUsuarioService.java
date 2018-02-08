package com.giovannicarmo.webserviceappoio.services;


import com.giovannicarmo.webserviceappoio.domain.MensagemUsuario;
import com.giovannicarmo.webserviceappoio.repositories.MensagemUsuarioRepository;
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
}
