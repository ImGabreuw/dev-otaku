package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.shared.validation.SelfValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsernameTest {

    @DisplayName("Should create Username")
    @Test
    void shouldCreateUsername() {
        var username = "Username";

        Username underTest = new Username(username);

        assertThat(underTest.value()).isEqualTo(username);
    }

    @DisplayName("Should throw ValidationException when create Username because Value is null or blank")
    @NullSource
    @ValueSource(strings = "   ")
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateUsernameBecauseValueIsNullOrBlank(String username) {
        assertThatThrownBy(() -> new Username(username))
                .isInstanceOf(SelfValidation.ValidationException.class);
    }

    @DisplayName("Should throw ValidationException when create Username because Value is empty")
    @EmptySource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateUsernameBecauseValueIsEmpty(String username) {
        assertThatThrownBy(() -> new Username(username))
                .isInstanceOf(SelfValidation.ValidationException.class);
    }

    @DisplayName("Should throw ValidationException when create Username because Value has size smaller than 2")
    @ValueSource(strings = "a")
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateUsernameBecauseValueHasSizeSmallerThan2(String username) {
        assertThatThrownBy(() -> new Username(username))
                .isInstanceOf(SelfValidation.ValidationException.class);
    }

    @DisplayName("Should throw ValidationException when create Username because Value has size larger than 20")
    @Test
    void shouldThrowValidationExceptionWhenCreateUsernameBecauseValueHasSizeLargerThan20() {
        var username = "a".repeat(21);

        assertThatThrownBy(() -> new Username(username))
                .isInstanceOf(SelfValidation.ValidationException.class);
    }

}