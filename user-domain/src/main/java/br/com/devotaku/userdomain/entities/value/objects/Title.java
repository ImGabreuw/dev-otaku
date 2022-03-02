package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Title(
        @NotBlank(message = "O campo 'Title' é obrigatório")
        String value
) implements SelfValidation<Title> {

    public Title(String value) {
        this.value = value;

        validate(this);
    }

}
