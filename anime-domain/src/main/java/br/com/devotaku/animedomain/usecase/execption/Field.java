package br.com.devotaku.animedomain.usecase.execption;

import br.com.devotaku.shared.reflection.ReflectionHelper;

import java.util.Arrays;
import java.util.stream.Collectors;

public record Field(String name, Object value) {

    public static String formatFields(Class<?> clazz, Field... fields) {
        return Arrays.stream(fields)
                .map(field -> ReflectionHelper.validateFieldName(clazz, field.name()) + "=" + field.value())
                .collect(Collectors.joining(" e/ou "));
    }

}
