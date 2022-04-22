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

class DescriptionTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = Faker.instance();
    }

    @DisplayName("Should create Description")
    @Test
    void shouldCreateDescription() {
        var description = faker.lorem().sentence(15);

        Description underTest = new Description(description);

        assertThat(underTest.value()).isEqualTo(description);
    }

    @DisplayName("Should throw ValidationException when create Description because is null or empty or blank")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateDescriptionBecauseIsNullOrEmptyOrBlank(String description) {
        assertThatThrownBy(() -> new Description(description))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("Field[fieldName=value, message=must not be blank, value=%s".formatted(description));
    }

}