package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.domain.entities.value.objects.Identifier;
import br.com.devotaku.animeservice.shared.validation.SelfValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.devotaku.animeservice.utils.IdentifierUtils.MAXIMUM_DEFAULT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IdentifierUtilsTest {

    private static IdentifierUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = IdentifierUtils.getInstance();
    }

    @DisplayName("Should generate Identifier")
    @Test
    void shouldGenerateIdentifier() {
        var identifier = underTest.generateIdentifier();

        assertThat(identifier.value()).isBetween(1L, MAXIMUM_DEFAULT_VALUE);
    }

    @DisplayName("Should generate Identifier value")
    @Test
    void shouldGenerateIdentifierValue() {
        var value = underTest.generateIdentifierValue();

        var identifier = new Identifier(value);

        assertThat(identifier.value()).isBetween(1L, MAXIMUM_DEFAULT_VALUE);
    }

    @DisplayName("Should generate invalid Identifier value")
    @Test
    void shouldGenerateInvalidIdentifierValue() {
        var value = underTest.generateInvalidIdentifierValue();

        assertThatThrownBy(() -> new Identifier(value))
                .isInstanceOf(SelfValidation.ValidationException.class);
    }

}