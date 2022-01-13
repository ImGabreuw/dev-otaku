package br.com.devotaku.animedomain.usecase.execption;

import br.com.devotaku.animedomain.entity.Anime;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<? extends Anime> entityClass, Field... fields) {
        super(String.format(
                "Não foi possível encontrar um [%s] com [%s]",
                entityClass.getSimpleName().toLowerCase(),
                Field.formatFields(entityClass, fields)
        ));
    }

}
