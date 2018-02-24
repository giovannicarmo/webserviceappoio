package com.giovannicarmo.webserviceappoio.resources;

import com.giovannicarmo.webserviceappoio.domain.MensagemUsuario;
import com.giovannicarmo.webserviceappoio.domain.MensagemUsuarioPK;
import com.giovannicarmo.webserviceappoio.services.MensagemUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/mensagens")
public class MensagemUsuarioResource {

    @Autowired
    MensagemUsuarioService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        List<MensagemUsuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MensagemUsuario> find(@PathVariable MensagemUsuarioPK id) {
        MensagemUsuario object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<MensagemUsuario> save(@RequestBody MensagemUsuario object) {
        object = service.insert(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MensagemUsuario> delete(@PathVariable MensagemUsuarioPK id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
