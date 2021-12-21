package br.com.devotaku.animedomain.entity.value.object;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Producer(
        @NotBlank String name
) implements SelfValidation<Producer> {

    public Producer(String name) {
        this.name = name;
        validate(this);
    }

}
