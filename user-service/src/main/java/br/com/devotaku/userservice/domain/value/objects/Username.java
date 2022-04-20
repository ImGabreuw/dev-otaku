package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record Username(
        @NotBlank
        @Size(min = 2, max = 20)
        String value
) implements SelfValidation<Username> {

    public Username(@NotBlank String value) {
        this.value = value;
        validate(this);
    }

}
