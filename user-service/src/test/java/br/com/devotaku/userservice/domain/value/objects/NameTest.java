package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.shared.validation.SelfValidation;
import br.com.devotaku.userservice.utils.annotation.BlankSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

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

    @DisplayName("Should throw ValidationException when create Name")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateName(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(SelfValidation.ValidationException.class);
    }

}