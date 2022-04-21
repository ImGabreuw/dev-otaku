package br.com.devotaku.userservice.shared.validation.validators;

import br.com.devotaku.userservice.shared.validation.annotations.ContainsSymbols;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainsSymbolsValidator implements ConstraintValidator<ContainsSymbols, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("(.*\\W.*)");
    }

}
