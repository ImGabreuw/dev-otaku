package br.com.devotaku.animeservice.shared.exceptions;

import br.com.devotaku.animeservice.domain.usecases.UseCase;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

public class IllegalInputException extends BaseException {

    public IllegalInputException(Class<? extends UseCase.InputValues> inputClass, Field... fields) {
        super("Invalid input value for class [%s] with (%s)".formatted(
                getInputValuesClassName(inputClass),
                Field.formatFields(inputClass, fields)
        ));
    }

    private static String getInputValuesClassName(Class<? extends UseCase.InputValues> clazz) {
        String[] elements = clazz.getName().split("\\.");

        return elements[elements.length - 1].replace("$", ".");
    }

    @Override
    public int getStatusCode() {
        return BAD_GATEWAY.value();
    }

}
