package com.giovannicarmo.webserviceappoio.resources;

import com.giovannicarmo.webserviceappoio.domain.Rotina;
import com.giovannicarmo.webserviceappoio.services.RotinaService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
