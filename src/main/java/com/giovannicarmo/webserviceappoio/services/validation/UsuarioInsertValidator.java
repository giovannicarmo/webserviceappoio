package com.giovannicarmo.webserviceappoio.services.validation;

import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.dto.UsuarioNewDTO;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import com.giovannicarmo.webserviceappoio.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioNewDTO> {

    @Autowired
    UsuarioRepository repository;

    @Override
    public void initialize(UsuarioInsert ann) {
    }
    @Override
    public boolean isValid(UsuarioNewDTO objectDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
        Usuario aux = repository.findByEmail(objectDto.getEmail());
        if (aux != null)
            list.add(new FieldMessage("email", "Email existente."));
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
