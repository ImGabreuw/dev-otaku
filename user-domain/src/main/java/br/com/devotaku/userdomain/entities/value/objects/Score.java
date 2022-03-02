package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

public record Score(
        @Digits(integer = 2, fraction = 2)
        @DecimalMin(value = "0.00", message = "O campo 'Score' deve conter um número entre 0.00 e 10.00")
        @DecimalMax(value = "10.00", message = "O campo 'Score' deve conter um número entre 0.00 e 10.00")
        Double value
) implements SelfValidation<Score> {

    public Score(Double value) {
        this.value = value;

        validate(this);
    }

}
