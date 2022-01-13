package br.com.devotaku.animedomain.entity.value.object;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record AlternativeName(
        @NotBlank(message = "O campo 'name' é obrigatório") String name
) implements SelfValidation<AlternativeName> {

    public AlternativeName(String name) {
        this.name = name;

        validate(this);
    }

}
