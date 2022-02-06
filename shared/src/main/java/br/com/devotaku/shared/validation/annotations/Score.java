package br.com.devotaku.shared.validation.annotations;

import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static br.com.devotaku.shared.validation.annotations.Score.MESSAGE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@ConstraintComposition

@Digits(integer = 2, fraction = 2)
@DecimalMin(value = "0.00", message = MESSAGE)
@DecimalMax(value = "10.00", message = MESSAGE)
public @interface Score {

    String MESSAGE = "O campo 'Score' deve conter um número entre 0.00 e 10.00";

    String message() default MESSAGE;

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};

}
