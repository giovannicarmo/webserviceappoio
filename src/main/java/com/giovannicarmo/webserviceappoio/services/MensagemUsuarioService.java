package com.giovannicarmo.webserviceappoio.services;


import com.giovannicarmo.webserviceappoio.domain.MensagemUsuario;
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

    public List<MensagemUsuario> listChat(Integer usuarioRemetenteId, Integer usuarioReceptorId) {
        return repository.chats(usuarioRemetenteId, usuarioReceptorId);
    }

    public MensagemUsuario find(MensagemUsuario id) {
        MensagemUsuario object = null; //repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + MensagemUsuario.class.getName());
        }
        return object;
    }

    public MensagemUsuario insert(MensagemUsuario object) {
        object.setId(null);
        return repository.save(object);
    }

    public void delete(MensagemUsuario id) {
        find(id);
        try{
            repository.delete(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Nao pode ser excluido pois esta relacionado com outras entidades");
        }
    }
}
