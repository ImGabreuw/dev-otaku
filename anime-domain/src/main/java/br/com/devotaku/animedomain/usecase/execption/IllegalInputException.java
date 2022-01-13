package br.com.devotaku.animedomain.usecase.execption;

import br.com.devotaku.shared.usecase.UseCase;

public class IllegalInputException extends RuntimeException {

    public IllegalInputException(Class<? extends UseCase.InputValues> inputClass, Field... fields) {
        super(String.format(
                "Valor de entrada inválido para [%s] com [%s]",
                getInputValuesClassName(inputClass),
                Field.formatFields(inputClass, fields)
        ));
    }

    private static String getInputValuesClassName(Class<? extends UseCase.InputValues> clazz) {
        String[] elements = clazz.getName().split("\\.");

        return elements[elements.length - 1].replace("$", ".");
    }

}
