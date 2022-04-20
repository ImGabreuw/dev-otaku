package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.shared.validation.SelfValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("Should create name")
    @Test
    void shouldCreateName() {
        var name = "Username";

        Name underTest = new Name(name);

        assertThat(underTest.value()).isEqualTo(name);
    }

    @DisplayName("Should throw ValidationException when create Name because value is null or blank")
    @NullSource
    @ValueSource(strings = "   ")
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateNameBecauseIsNullOrBlank(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessage(String.format(
                        "The class Name have its constraints violated. [Field[fieldName=value, message=must not be blank, value=%s]]",
                        name
                ));
    }

    @DisplayName("Should throw ValidationException when create Name because Value is empty")
    @EmptySource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateNameBecauseValueIsEmpty(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(SelfValidation.ValidationException.class);
    }

}