package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Rotina;
import com.giovannicarmo.webserviceappoio.repositories.RotinaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotinaService {

    @Autowired
    private RotinaRepository repository;

    public List<Rotina> findAll(){
        return repository.findAll();
    }

    public Page<Rotina> search(String nomeCrianca, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.search(nomeCrianca, pageRequest);
    }

    public Rotina find(Integer id) {
        Rotina object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Rotina.class.getName());

        }
        return object;
    }

    public Rotina insert(Rotina object) {
        return repository.save(object);
    }

    private void updateData(Rotina newObject, Rotina object) {
        newObject.setData(object.getData());
        newObject.setTipo(object.getTipo());
        newObject.setAtividades(object.getAtividades());
        newObject.setObs(object.getObs());
        newObject.setComportamento(object.getComportamento());
        newObject.setInteracao(object.getInteracao());
        newObject.setHumor(object.getHumor());
        newObject.setAlimentacao(object.getAlimentacao());
    }
}
