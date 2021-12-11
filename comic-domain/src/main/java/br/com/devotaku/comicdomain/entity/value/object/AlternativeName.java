package br.com.devotaku.comicdomain.entity.value.object;

import javax.validation.constraints.NotBlank;

public record AlternativeName(
        @NotBlank(message = "O campo Name não pode estar em branco")
        String name
) {
}
