package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Name(
        @NotBlank(message = "O campo 'Name' não pode estar em branco")
        String value
) implements SelfValidation<Name> {

    public Name(String value) {
        this.value = value;

        validate(this);
    }

}
