package br.com.devotaku.userservice.shared.validation.validators;

import br.com.devotaku.userservice.shared.validation.annotations.ContainsDigits;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainsDigitsValidator implements ConstraintValidator<ContainsDigits, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("(.*\\d.*)");
    }

}
