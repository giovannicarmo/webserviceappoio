package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.RecomendacaoMedica;
import com.giovannicarmo.webserviceappoio.repositories.RecomendacaoMedicaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacaoMedicaService {

    @Autowired
    private RecomendacaoMedicaRepository repository;

    public List<RecomendacaoMedica> findAll(){
        return repository.findAll();
    }

    public RecomendacaoMedica find(Integer id) {
        RecomendacaoMedica object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + RecomendacaoMedica.class.getName());
        }
        return object;
    }

    public RecomendacaoMedica insert(RecomendacaoMedica object) {
        object.setId(null);
        return repository.save(object);
    }

    public RecomendacaoMedica update(RecomendacaoMedica object) {
        RecomendacaoMedica newObject = find(object.getId());
        updateData(newObject, object);
        return repository.save(newObject);
    }

    public void delete(Integer id) {
        find(id);
        try{
            repository.delete(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Nao pode ser excluido pois esta relacionado com outras entidades");
        }
    }

    private void updateData(RecomendacaoMedica newObject, RecomendacaoMedica object) {
       newObject.setObservacao(object.getObservacao());
    }
}
