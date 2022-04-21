package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Email(
        @NotBlank
        @javax.validation.constraints.Email
        String value
) implements SelfValidation<Email> {

    public Email(String value) {
        this.value = value;
        validate(this);
    }

}
