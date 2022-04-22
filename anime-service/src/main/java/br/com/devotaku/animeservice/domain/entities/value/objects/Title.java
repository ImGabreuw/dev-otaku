package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record Title(
        @NotBlank
        @Size(max = 255)
        String value
) implements SelfValidation<Title> {

    public Title(String value) {
        this.value = value;
        validate(this);
    }

}
