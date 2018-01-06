package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.RecomendacaoMedica;
import com.giovannicarmo.webserviceappoio.repositories.RecomendacaoMedicaRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecomendacaoMedicaService {

    @Autowired
    private RecomendacaoMedicaRepository repository;

    public RecomendacaoMedica find(Integer id) {
        RecomendacaoMedica recomendacaoMedica = repository.findOne(id);
        if(recomendacaoMedica == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + RecomendacaoMedica.class.getName());
        }
        return recomendacaoMedica;
    }
}
