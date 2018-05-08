package com.giovannicarmo.webserviceappoio.resources;


import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.dto.UsuarioDTO;
import com.giovannicarmo.webserviceappoio.dto.UsuarioNewDTO;
import com.giovannicarmo.webserviceappoio.services.UsuarioService;
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
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    UsuarioService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> list = service.findAll();
        List<UsuarioDTO> objectDTOS = list.stream().map(object -> new UsuarioDTO(object)).collect(Collectors.toList());
        return ResponseEntity.ok().body(objectDTOS);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> find(@PathVariable Integer id) {
        Usuario object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    //cuidado
    @RequestMapping(path = "/email", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> find(@RequestParam(value = "value") String email){
        Usuario obj = service.findByEmail(email);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioNewDTO objectDTO) {
        Usuario object = service.fromDTO(objectDTO);
        object = service.insert(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario object, @PathVariable Integer id) {
        object.setId(id);
        service.update(object);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable Integer id){
       service.delete(id);
       return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public ResponseEntity<Void> uploadProfilePicture (@RequestParam(name="file") MultipartFile file) {

        URI uri = service.uploadProfilePicture(file);
        return ResponseEntity.created(uri).build();
    }
}
