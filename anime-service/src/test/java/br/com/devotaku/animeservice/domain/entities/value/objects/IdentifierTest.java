package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;
import br.com.devotaku.animeservice.utils.annotations.IdentifierUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IdentifierTest {

    private static IdentifierUtils identifierUtils;

    @BeforeAll
    static void beforeAll() {
        identifierUtils = IdentifierUtils.getInstance();
    }

    @DisplayName("Should create Identifier")
    @Test
    void shouldCreateIdentifier() {
        var id = identifierUtils.generateRandomId();

        Identifier underTest = new Identifier(id);

        assertThat(underTest.value()).isEqualTo(id);
    }

    @DisplayName("Should throw ValidationException when create Identifier because is null")
    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateIdentifierBecauseIsNull(Long id) {
        assertThatThrownBy(() -> new Identifier(id))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be null, value=%s".formatted(id));
    }

    @DisplayName("Should throw ValidationException when create Identifier because is negative or zero")
    @ValueSource(longs = {-1, 0})
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateIdentifierBecauseIsNegativeOrZero(Long id) {
        assertThatThrownBy(() -> new Identifier(id))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must be greater than 0, value=%s".formatted(id));
    }

}