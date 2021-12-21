package br.com.devotaku.animedomain.entity.value.object;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record AlternativeName(
        @NotBlank String name
) implements SelfValidation<AlternativeName> {

    public AlternativeName(@NotBlank String name) {
        this.name = name;
        validate(this);
    }

}
