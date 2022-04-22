package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;
import br.com.devotaku.animeservice.utils.annotations.BlankSource;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AlternativeNameTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = Faker.instance();
    }

    @DisplayName("Should create AlternativeName")
    @Test
    void shouldCreateAlternativeName() {
        var alternativeName = faker.name().title();

        AlternativeName underTest = new AlternativeName(alternativeName);

        assertThat(underTest.value()).isEqualTo(alternativeName);
    }

    @DisplayName("Should throw ValidationException when create AlternativeName because is null or empty or blank")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateAlternativeNameBecauseIsNullOrEmptyOrBlank(String alternativeName) {
        assertThatThrownBy(() -> new AlternativeName(alternativeName))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("Field[fieldName=value, message=must not be blank, value=%s]".formatted(alternativeName));
    }

    @DisplayName("Should throw ValidationException when create AlternativeName because has size larger than 255")
    @Test
    void shouldThrowValidationExceptionWhenCreateAlternativeNameBecauseHasSizeLargerThan255() {
        String alternativeName = "a".repeat(256);

        assertThatThrownBy(() -> new AlternativeName(alternativeName))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=size must be between 0 and 255, value=%s".formatted(alternativeName));
    }

}