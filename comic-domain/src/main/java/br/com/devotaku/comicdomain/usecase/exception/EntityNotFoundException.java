package br.com.devotaku.comicdomain.usecase.exception;

import br.com.devotaku.comicdomain.entity.Comic;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<? extends Comic> entityClass, Field... fields) {
        super(String.format(
                "Não foi possível encontrar um [%s] com [%s]",
                entityClass.getSimpleName().toLowerCase(),
                Field.formatFields(entityClass, fields)
        ));
    }

}
