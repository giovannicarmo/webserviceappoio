package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.domain.Rotina;
import com.giovannicarmo.webserviceappoio.domain.RotinaPK;
import com.giovannicarmo.webserviceappoio.repositories.CriancaRepository;
import com.giovannicarmo.webserviceappoio.repositories.RotinaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotinaService {

    @Autowired
    private RotinaRepository repository;

    @Autowired
    private CriancaRepository criancaRepository;

    public List<Rotina> findAll(){
        return repository.findAll();
    }

    public Rotina find(RotinaPK id) {
        Rotina object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Rotina.class.getName());
        }
        return object;
    }

    public Page<Rotina> search(Integer id, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Crianca crianca =  criancaRepository.findOne(id);
        return repository.search(id, crianca, pageRequest);
    }

    public Rotina insert(Rotina object) {
        object.setId(null);
        return repository.save(object);
    }

    public Rotina update(Rotina object) {
        Rotina newObject = find(object.getId());
        updateData(newObject, object);
        return repository.save(newObject);
    }
//
//    public void delete(RotinaPK id) {
//        find(id);
//        try{
//            repository.delete(id);
//        } catch (DataIntegrityViolationException e){
//            throw new DataIntegrityException("Nao pode ser excluido pois esta relacionado com outras entidades");
//        }
//    }

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
