package com.giovannicarmo.webserviceappoio.resources;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.dto.CriancaDTO;
import com.giovannicarmo.webserviceappoio.dto.CriancaNewDTO;
import com.giovannicarmo.webserviceappoio.services.CriancaService;
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
@RequestMapping(value = "/criancas")
public class CriancaResource {

    @Autowired
    CriancaService service;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public ResponseEntity<List<Crianca>> criancaUsuario (
            @RequestParam(value = "id", defaultValue = "") Integer id_usuario) {
        List<Crianca> list = service.criancaUsuario(id_usuario);
        return ResponseEntity.ok().body(list);
    }

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

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Crianca> save(@Valid @RequestBody CriancaNewDTO objectDTO, Usuario usuario) {
        Crianca object = service.fromDTO(objectDTO);
        object = service.insert(object);
        usuarioService.update(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Crianca> update(@Valid @RequestBody Crianca object, Usuario usuario, @PathVariable Integer id) {
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
    public ResponseEntity<Void> uploadCriancaPicture (@PathVariable Integer id, @RequestParam(name="file") MultipartFile file) {

        URI uri = service.uploadCriancaPicture(id, file);
        return ResponseEntity.created(uri).build();
    }
}
