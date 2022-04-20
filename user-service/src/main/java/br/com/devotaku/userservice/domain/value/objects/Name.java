package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Name(@NotBlank String value) implements SelfValidation<Name> {

    public Name(@NotBlank String value) {
        this.value = value;
        validate(this);
    }

}
