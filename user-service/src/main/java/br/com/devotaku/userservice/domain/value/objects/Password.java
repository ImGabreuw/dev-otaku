package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.domain.ports.Encryptor;
import br.com.devotaku.userservice.shared.validation.SelfValidation;
import br.com.devotaku.userservice.shared.validation.annotations.ContainsDigits;
import br.com.devotaku.userservice.shared.validation.annotations.ContainsLowercase;
import br.com.devotaku.userservice.shared.validation.annotations.ContainsSymbols;
import br.com.devotaku.userservice.shared.validation.annotations.ContainsUppercase;

import javax.validation.constraints.Size;

public record Password(
        @Size(min = 8, max = 30)
        @ContainsUppercase
        @ContainsLowercase
        @ContainsDigits
        @ContainsSymbols
        String value,
        Encryptor encryptor
) implements SelfValidation<Password> {

    public Password(String value) {
        this(value, Encryptor.DefaultEncryptor.getInstance());
    }

    public Password(String value, Encryptor encryptor) {
        this.encryptor = encryptor;
        this.value = value;

        validate(this);
    }

    @Override
    public String value() {
        return encryptor.encode(value);
    }

}
