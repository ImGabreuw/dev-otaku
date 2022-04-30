package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.domain.entities.value.objects.Description;
import br.com.devotaku.animeservice.shared.generators.DescriptionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.devotaku.animeservice.shared.generators.DescriptionUtils.LENGTH_DEFAULT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class DescriptionUtilsTest {

    private static DescriptionUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = DescriptionUtils.getInstance();
    }

    @DisplayName("Should create Description with 20 characters")
    @Test
    void shouldCreateDescriptionWith20Characters() {
        var length = 20;
        var description = underTest.generateDescription(length);

        assertThat(description.value()).hasSize(length);
    }

    @DisplayName("Should create Description with the length default value")
    @Test
    void shouldCreateDescriptionWithTheLengthDefaultValue() {
        var description = underTest.generateDescription();

        assertThat(description.value()).hasSize(LENGTH_DEFAULT_VALUE);
    }

    @DisplayName("Should generate Description value with the length default value")
    @Test
    void shouldGenerateDescriptionValue() {
        var value = underTest.generateDescriptionValue();
        var description = new Description(value);

        assertThat(description.value())
                .isEqualTo(value)
                .hasSize(LENGTH_DEFAULT_VALUE);
    }

    @DisplayName("Should generate Description value with 20 characters")
    @Test
    void shouldGenerateDescriptionValueWith20Characters() {
        var length = 20;
        var value = underTest.generateDescriptionValue(length);
        var description = new Description(value);

        assertThat(description.value())
                .isEqualTo(value)
                .hasSize(length);
    }

}