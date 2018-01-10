package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.domain.Mensagem;
import com.giovannicarmo.webserviceappoio.repositories.MensagemRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository repository;

    public Mensagem find (Integer id) {
        Mensagem mensagem = repository.findOne(id);
        if(mensagem == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Crianca.class.getName());
        }
        return mensagem;
    }
}
