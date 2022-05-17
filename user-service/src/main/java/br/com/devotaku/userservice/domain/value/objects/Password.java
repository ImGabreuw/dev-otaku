package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.domain.ports.protocols.Encryptor;
import br.com.devotaku.userservice.shared.validation.SelfValidation;
import br.com.devotaku.userservice.shared.validation.annotations.ContainsDigits;
import br.com.devotaku.userservice.shared.validation.annotations.ContainsLowercase;
import br.com.devotaku.userservice.shared.validation.annotations.ContainsSymbols;
import br.com.devotaku.userservice.shared.validation.annotations.ContainsUppercase;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class Password implements SelfValidation<Password> {

    private final Encryptor encryptor;

    @Size(min = 8, max = 30)
    @ContainsUppercase
    @ContainsLowercase
    @ContainsDigits
    @ContainsSymbols
    private String value;

    public Password(String value) {
        this(value, Encryptor.Base64.getInstance());
    }

    public Password(String value, Encryptor encryptor) {
        this.encryptor = encryptor;
        this.value = value;

        validate(this);

        this.value = encryptor.encode(value);
    }

}
