package com.giovannicarmo.webserviceappoio.resources;

import com.giovannicarmo.webserviceappoio.domain.Rotina;
import com.giovannicarmo.webserviceappoio.services.RotinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/rotinas")
public class RotinaResource {

    @Autowired
    RotinaService service;

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Rotina> find(@PathVariable Integer id) {
        Rotina object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        List<Rotina> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Rotina>> findPage(
            @RequestParam(value = "id_crianca", defaultValue = "") Integer id,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        Page<Rotina> list = service.search(id, page, linesPerPage, direction, orderBy);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Rotina> save(@RequestBody Rotina object) {
        object = service.insert(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
