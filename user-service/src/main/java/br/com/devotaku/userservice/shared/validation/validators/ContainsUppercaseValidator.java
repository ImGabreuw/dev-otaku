package br.com.devotaku.userservice.shared.validation.validators;

import br.com.devotaku.userservice.shared.validation.annotations.ContainsUppercase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainsUppercaseValidator implements ConstraintValidator<ContainsUppercase, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("(.*[A-Z].*)");
    }

}
