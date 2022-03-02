package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotNull;

public record Email(
        @NotNull(message = "O campo 'Login' é obrigatório")
        @javax.validation.constraints.Email(message = "O campo 'Email' deve conter um email válido")
        String value
) implements SelfValidation<Email> {

    public Email(String value) {
        this.value = value;

        validate(this);
    }

}
