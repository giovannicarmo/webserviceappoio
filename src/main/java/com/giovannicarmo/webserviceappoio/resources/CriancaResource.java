package com.giovannicarmo.webserviceappoio.resources;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.dto.CriancaDTO;
import com.giovannicarmo.webserviceappoio.services.CriancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/criancas")
public class CriancaResource {

    @Autowired
    CriancaService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<CriancaDTO>> findAll(){
        List<Crianca> list = service.findAll();
        List<CriancaDTO> objectDTOS = list.stream().map(object -> new CriancaDTO(object)).collect(Collectors.toList());
        return ResponseEntity.ok().body(objectDTOS);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Crianca> find(@PathVariable Integer id) {
        Crianca object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Crianca>> findByUsuarios(@PathVariable Integer id){
        List<Crianca> list = service.findByUsuario(id);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Crianca> save(@RequestBody Crianca object) {
        object = service.insert(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Crianca> update(@Valid @RequestBody Crianca object, @PathVariable Integer id) {
        object.setId(id);
        service.update(object);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Crianca> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/picture/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> uploadProfilePicture (@PathVariable Integer id, @RequestParam(name="file") MultipartFile file) {
        URI uri = service.uploadPicture(id, file);
        return ResponseEntity.created(uri).build();
    }
}
