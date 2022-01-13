package br.com.devotaku.comicdomain.entity.value.object;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record AlternativeName(
        @NotBlank(message = "O campo Name não pode estar em branco")
        String name
) implements SelfValidation<AlternativeName> {

    public AlternativeName(String name) {
        this.name = name;

        validate(this);
    }

}
