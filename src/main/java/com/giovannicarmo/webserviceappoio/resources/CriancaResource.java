package com.giovannicarmo.webserviceappoio.resources;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.services.CriancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/criancas")
public class CriancaResource {

    @Autowired
    CriancaService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        List<Crianca> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Crianca object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Crianca object) {
        object = service.save(object);
        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody Crianca object) {
        service.save(object);
        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
