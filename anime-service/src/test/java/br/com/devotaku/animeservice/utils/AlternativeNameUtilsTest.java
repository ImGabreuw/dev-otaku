package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.domain.entities.value.objects.AlternativeName;
import br.com.devotaku.animeservice.shared.generators.AlternativeNameUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.devotaku.animeservice.shared.generators.AlternativeNameUtils.LIMIT_DEFAULT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class AlternativeNameUtilsTest {

    private static AlternativeNameUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = AlternativeNameUtils.getInstance();
    }

    @DisplayName("Should generate AlternativeName")
    @Test
    void shouldGenerate() {
        var alternativeName = underTest.generateAlternativeName();

        assertThat(alternativeName).isNotNull();
    }

    @DisplayName("Should generate AlternativeName value")
    @Test
    void shouldGenerateAlternativeNameValue() {
        var value = underTest.generateAlternativeNameValue();

        var alternativeName = new AlternativeName(value);

        assertThat(alternativeName.value()).isEqualTo(value);
    }

    @DisplayName("Should generate a list of AlternativeName")
    @Test
    void shouldGenerateAListOfAlternativeName() {
        var alternativeNames = underTest.generateAlternativeNameSequence();

        assertThat(alternativeNames).hasSize(LIMIT_DEFAULT_VALUE);
    }

    @DisplayName("Should generate a list with 3 AlternativeName")
    @Test
    void shouldGenerateAListWith3AlternativeName() {
        var alternativeNames = underTest.generateAlternativeNameSequence(3);

        assertThat(alternativeNames).hasSize(3);
    }

}