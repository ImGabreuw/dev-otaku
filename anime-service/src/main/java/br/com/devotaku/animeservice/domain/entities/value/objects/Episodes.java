package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record Episodes(
        @NotNull
        @Positive
        Integer value
) implements SelfValidation<Episodes> {

    public Episodes(Integer value) {
        this.value = value;
        validate(this);
    }

}
