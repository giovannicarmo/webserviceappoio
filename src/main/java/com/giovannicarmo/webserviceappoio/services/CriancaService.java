package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.domain.enums.CategoriaTea;
import com.giovannicarmo.webserviceappoio.domain.enums.Sexo;
import com.giovannicarmo.webserviceappoio.dto.CriancaNewDTO;
import com.giovannicarmo.webserviceappoio.repositories.CriancaRepository;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import com.giovannicarmo.webserviceappoio.services.excepition.DataIntegrityException;
import com.giovannicarmo.webserviceappoio.services.excepition.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CriancaService {

    @Autowired
    private CriancaRepository repository;

    public List<Crianca> criancaUsuario(Integer id_usuario) {
        return repository.criancaUsuario(id_usuario);
    }

    public List<Crianca> findAll(){
        return repository.findAll();
    }

    public Crianca find(Integer id) {
        Crianca object = repository.findOne(id);
        if(object == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + "Tipo: " + Crianca.class.getName());
        }
        return object;
    }

    public Page<Crianca> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Crianca insert(Crianca object) {
        object.setId(null);
        return repository.save(object);
    }

    public Crianca update(Crianca object) {
        Crianca newObject = find(object.getId());
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

    public Crianca fromDTO (CriancaNewDTO objectDTO) {
        Crianca object = new Crianca(null, objectDTO.getNome(), objectDTO.getColegio(), objectDTO.getFoto(),
                objectDTO.getDataNascimento(), Sexo.toEnum(objectDTO.getSexo()),
                CategoriaTea.toEnum(objectDTO.getCategoriaTea()));
        return object;
    }

    private void updateData(Crianca newObject, Crianca object) {
        newObject.setNome(object.getNome());
        newObject.setColegio(object.getColegio());
        newObject.setFoto(object.getFoto());
        newObject.setDataNascimento(object.getDataNascimento());
        newObject.setSexo(object.getSexo());
        newObject.setCategoriaTea(object.getCategoriaTea());
        newObject.setUsuarios(object.getUsuarios());
    }
}
