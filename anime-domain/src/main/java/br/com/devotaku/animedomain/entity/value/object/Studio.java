package br.com.devotaku.animedomain.entity.value.object;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Studio(
        @NotBlank String name
) implements SelfValidation<Studio> {

    public Studio(String name) {
        this.name = name;
        validate(this);
    }

}
