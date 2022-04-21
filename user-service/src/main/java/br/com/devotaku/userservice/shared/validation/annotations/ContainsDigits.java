package br.com.devotaku.userservice.shared.validation.annotations;

import br.com.devotaku.userservice.shared.validation.validators.ContainsDigitsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = ContainsDigitsValidator.class)
public @interface ContainsDigits {

    String message() default "must contain at least one digit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
