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

class StudioTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = Faker.instance();
    }

    @DisplayName("Should create Studio")
    @Test
    void shouldCreateStudio() {
        var studio = faker.company().name();

        Studio underTest = new Studio(studio);

        assertThat(underTest.value()).isEqualTo(studio);
    }

    @DisplayName("Should throw ValidationException when create Studio because is null, empty or blank")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateStudioBecauseIsNullEmptyOrBlank(String studio) {
        assertThatThrownBy(() -> new Studio(studio))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be blank, value=%s".formatted(studio));
    }

    @DisplayName("Should throw ValidationException when create Studio because has size larger than 255")
    @Test
    void shouldThrowValidationExceptionWhenCreateStudioBecauseHasSizeLargerThan255() {
        var studio = "a".repeat(256);

        assertThatThrownBy(() -> new Studio(studio))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=size must be between 0 and 255, value=%s".formatted(studio));
    }

}