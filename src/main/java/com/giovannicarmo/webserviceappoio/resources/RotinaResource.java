package com.giovannicarmo.webserviceappoio.resources;

import com.giovannicarmo.webserviceappoio.domain.Rotina;
import com.giovannicarmo.webserviceappoio.services.RotinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rotinas")
public class RotinaResource {

    @Autowired
    RotinaService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        List<Rotina> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Rotina object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Rotina object) {
        object = service.save(object);
        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody Rotina object) {
        service.save(object);
        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
