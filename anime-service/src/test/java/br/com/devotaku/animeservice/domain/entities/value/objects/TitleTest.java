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

class TitleTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = Faker.instance();
    }


    @DisplayName("Should create Title")
    @Test
    void shouldCreateTitle() {
        var title = faker.name().title();

        Title underTest = new Title(title);

        assertThat(underTest.value()).isEqualTo(title);
    }

    @DisplayName("Should throw ValidationException when create Title because is null, empty or blank")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateTitleBecauseIsNullEmptyOrBlank(String title) {
        assertThatThrownBy(() -> new Title(title))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be blank, value=%s".formatted(title));
    }

    @DisplayName("Should throw ValidationException when create Title because has size larger than 255")
    @Test
    void shouldThrowValidationExceptionWhenCreateTitleBecauseHasSizeLargerThan255() {
        var title = "a".repeat(256);

        assertThatThrownBy(() -> new Title(title))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=size must be between 0 and 255, value=%s".formatted(title));
    }

}