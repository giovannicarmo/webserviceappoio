package com.giovannicarmo.webserviceappoio.resources;

import com.giovannicarmo.webserviceappoio.domain.RecomendacaoMedica;
import com.giovannicarmo.webserviceappoio.services.RecomendacaoMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/recomendacoesMedicas")
public class RecomendacaoMedicaResource {

    @Autowired
    RecomendacaoMedicaService service;

    @RequestMapping(value = "crianca/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<RecomendacaoMedica>> findAllByCrianca(@PathVariable Integer id){
        List<RecomendacaoMedica> list = service.findAllByCrianca(id);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RecomendacaoMedica> find(@PathVariable Integer id) {
        RecomendacaoMedica object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<RecomendacaoMedica> save(@RequestBody RecomendacaoMedica object) {
        object = service.insert(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RecomendacaoMedica> update(@Valid @RequestBody RecomendacaoMedica object, @PathVariable Integer id) {
        object.setId(id);
        service.update(object);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<RecomendacaoMedica> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
