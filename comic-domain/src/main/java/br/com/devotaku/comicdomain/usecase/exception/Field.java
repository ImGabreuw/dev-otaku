package br.com.devotaku.comicdomain.usecase.exception;

import br.com.devotaku.comicdomain.entity.Comic;
import br.com.devotaku.shared.reflection.ReflectionHelper;

import java.util.Arrays;
import java.util.stream.Collectors;

public record Field(String name, Object value) {

    public static String formatFields(Class<? extends Comic> entityClass, Field... fields) {
        return Arrays.stream(fields)
                .map(field -> ReflectionHelper.validateFieldName(entityClass, field.name()) + "=" + field.value())
                .collect(Collectors.joining(" e/ou "));
    }

}
