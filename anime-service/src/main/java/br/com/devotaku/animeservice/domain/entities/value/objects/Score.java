package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public record Score(
        @NotNull
        @DecimalMin("0.00")
        @DecimalMax("10.00")
        Double value
) implements SelfValidation<Score> {

    public Score(Double value) {
        this.value = value;
        validate(this);
    }

}
