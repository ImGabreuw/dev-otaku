package br.com.devotaku.userservice.shared.validation.annotations;

import br.com.devotaku.userservice.shared.validation.validators.ContainsSymbolsValidator;

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
@Constraint(validatedBy = ContainsSymbolsValidator.class)
public @interface ContainsSymbols {

    String message() default "must contain at least one special character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
