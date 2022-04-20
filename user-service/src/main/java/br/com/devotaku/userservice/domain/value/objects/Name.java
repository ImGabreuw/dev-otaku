package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record Name(
        @NotBlank
        @Size(min = 3, max = 50)
        String value
) implements SelfValidation<Name> {

    public Name(@NotBlank String value) {
        this.value = value;
        validate(this);
    }

}
