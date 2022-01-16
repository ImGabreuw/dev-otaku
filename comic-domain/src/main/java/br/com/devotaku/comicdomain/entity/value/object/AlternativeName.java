package br.com.devotaku.comicdomain.entity.value.object;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record AlternativeName(
        @NotBlank(message = "O campo Name não pode estar em branco")
        String value
) implements SelfValidation<AlternativeName> {

    public AlternativeName(String value) {
        this.value = value;

        validate(this);
    }

}
