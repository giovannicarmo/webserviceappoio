package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.RecomendacaoMedica;
import com.giovannicarmo.webserviceappoio.repositories.RecomendacaoMedicaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    public RecomendacaoMedica save(RecomendacaoMedica object) {
        repository.save(object);
        return object;
    }

    public RecomendacaoMedica update(Integer id, RecomendacaoMedica object) {
        object = find(id);
        repository.save(object);
        return object;
    }

    public RecomendacaoMedica delete(Integer id) {
        RecomendacaoMedica object = find(id);
        repository.delete(object);
        return object;
    }
}
