package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public record Progress(
        @NotNull(message = "O campo 'Seen' é obrigatório")
        @PositiveOrZero(message = "O campo 'Seen' deve conter um número inteiro maior ou igual a 0")
        Integer seen,

        @NotNull(message = "O campo 'Total' é obrigatório")
        @Positive(message = "O campo 'Total' deve conter um número inteiro maior que 0")
        Integer total
) implements SelfValidation<Progress> {

    public Progress(Integer seen, Integer total) {
        this.seen = seen;
        this.total = total;

        validate(this);
    }

    public Progress update(Integer seen) {
        return new Progress(
                seen,
                this.total
        );
    }

}
