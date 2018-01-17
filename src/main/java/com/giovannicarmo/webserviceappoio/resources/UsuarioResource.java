package com.giovannicarmo.webserviceappoio.resources;


import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    UsuarioService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        List<Usuario> objects = service.findAll();
        return ResponseEntity.ok().body(objects);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Usuario object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Usuario object) {
        object = service.save(object);
        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Usuario object) {
        service.update(id, object);
        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
       service.delete(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

}
