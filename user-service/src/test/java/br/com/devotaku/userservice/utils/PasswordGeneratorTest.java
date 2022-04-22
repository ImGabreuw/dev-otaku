package br.com.devotaku.userservice.utils;

import br.com.devotaku.userservice.domain.ports.Encryptor;
import br.com.devotaku.userservice.domain.value.objects.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordGeneratorTest {

    @DisplayName("Show generate a strong password")
    @Test
    void showGenerateAStrongPassword() {
        var password = PasswordGenerator.generatePassword(12, 13, true, true, true);

        Password underTest = new Password(password);

        assertThat(underTest.getValue()).isEqualTo(Encryptor.DefaultEncryptor.getInstance().encode(password));
    }

}