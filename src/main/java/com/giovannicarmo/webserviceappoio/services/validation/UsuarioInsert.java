package com.giovannicarmo.webserviceappoio.services.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UsuarioInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UsuarioInsert {
    String message() default "Validation error.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
