package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.domain.ports.Encryptor;
import br.com.devotaku.userservice.shared.validation.SelfValidation;
import br.com.devotaku.userservice.utils.PasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PasswordTest {

    @DisplayName("Should create Password")
    @Test
    void shouldCreatePassword() {
        var password = PasswordGenerator.generateStrongPassword(12);

        Password underTest = new Password(password);

        assertThat(underTest.value()).isEqualTo(Encryptor.DefaultEncryptor.getInstance().encode(password));
    }

    @DisplayName("Should throw ValidationException when create Password because size is smaller than 8")
    @Test
    void shouldThrowValidationExceptionWhenCreatePasswordBecauseSizeIsSmallerThan8() {
        var password = PasswordGenerator.generateStrongPassword(7);

        assertThatThrownBy(() -> new Password(password))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=size must be between 8 and 30, value=%s".formatted(password));
    }

    @DisplayName("Should throw ValidationException when create Password because does not contain at least one uppercase character")
    @Test
    void shouldThrowValidationExceptionWhenCreatePasswordBecauseDoesNotContainAtLeastOneUppercaseCharacter() {
        var password = PasswordGenerator.generatePasswordWithoutUppercase(8);

        assertThatThrownBy(() -> new Password(password))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must contain at least one uppercase character, value=%s".formatted(password));
    }

    @DisplayName("Should throw ValidationException when create Password because does not contain at least one lowercase character")
    @Test
    void shouldThrowValidationExceptionWhenCreatePasswordBecauseDoesNotContainAtLeastOneLowercaseCharacter() {
        var password = PasswordGenerator.generatePasswordWithoutLowercase(8);

        assertThatThrownBy(() -> new Password(password))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must contain at least one lowercase character, value=%s".formatted(password));
    }

    @DisplayName("Should throw ValidationException when create Password because does not contain at least one digit")
    @Test
    void shouldThrowValidationExceptionWhenCreatePasswordBecauseDoesNotContainAtLeastOneDigit() {
        var password = PasswordGenerator.generatePasswordWithoutDigits(8);

        assertThatThrownBy(() -> new Password(password))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must contain at least one digit, value=%s".formatted(password));
    }

    @DisplayName("Should throw ValidationException when create Password because does not contain at least one symbol")
    @Test
    void shouldThrowValidationExceptionWhenCreatePasswordBecauseDoesNotContainAtLeastOneSymbol() {
        var password = PasswordGenerator.generatePasswordWithoutSymbols(8);

        assertThatThrownBy(() -> new Password(password))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must contain at least one special character, value=%s".formatted(password));
    }

}