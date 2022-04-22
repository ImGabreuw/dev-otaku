package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record Identifier(
        @NotNull
        @Positive
        Long value
) implements SelfValidation<Identifier> {

    public Identifier(Long value) {
        this.value = value;
        validate(this);
    }

}
