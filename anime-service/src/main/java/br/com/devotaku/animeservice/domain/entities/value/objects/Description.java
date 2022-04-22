package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Description(
        @NotBlank
        String value
) implements SelfValidation<Description> {

    public Description(String value) {
        this.value = value;
        validate(this);
    }

}
