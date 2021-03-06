package br.com.devotaku.animeservice.shared.reflections;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ReflectionHelper {

    @SneakyThrows
    public static String validateFieldName(Class<?> entity, String fieldName) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(List.of(entity.getSuperclass().getDeclaredFields()));
        fields.addAll(List.of(entity.getDeclaredFields()));

        return fields.stream()
                .map(Field::getName)
                .filter(field -> field.equals(fieldName))
                .findAny()
                .orElseThrow(() -> new NoSuchFieldException(
                        "Cannot find any field named (%s) in entity (%s)".formatted(
                                fieldName,
                                entity.getSimpleName()
                        )
                ));
    }

}
