package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.domain.Rotina;
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
    private CriancaService criancaService;

    public List<Rotina> findAll(){
        return repository.findAll();
    }

    public Rotina find(Integer id) {
        Rotina object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + " Tipo: " + Rotina.class.getName());
        }
        return object;
    }

    public Page<Rotina> search(String nome, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.search(nome, pageRequest);
    }

    public Rotina insert(Rotina object) {
        return repository.save(object);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.delete(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Nao pode ser excluido pois esta relacionado com outras entidades");
        }
    }

    public void deleteAllByCrianca(Integer id) {
        Crianca crianca = criancaService.find(id);
        repository.deleteAllByCrianca(crianca);
    }
}
