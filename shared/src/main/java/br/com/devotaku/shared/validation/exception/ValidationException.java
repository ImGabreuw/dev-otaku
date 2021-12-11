package br.com.devotaku.shared.validation.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationException extends RuntimeException {

    private final List<Field> violatedFields = new ArrayList<>();

    public ValidationException(Object target, List<Field> violatedFields) {
        super(String.format(
                "A classe %s teve suas constraints violadas. %s",
                target.getClass().getSimpleName(),
                violatedFields
        ));
    }

}