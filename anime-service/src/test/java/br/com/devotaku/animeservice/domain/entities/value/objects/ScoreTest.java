package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoreTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = Faker.instance();
    }

    @DisplayName("Should create Score")
    @Test
    void shouldCreateScore() {
        var score = faker.number().randomDouble(2, 0, 10);

        Score underTest = new Score(score);

        assertThat(underTest.value()).isEqualTo(score);
    }

    @DisplayName("Should throw ValidationException when create Score because is null")
    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateScoreBecauseIsNull(Double score) {
        assertThatThrownBy(() -> new Score(score))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be null, value=%s".formatted(score));
    }

    @DisplayName("Should throw ValidationException when create Score because is smaller than 0.00")
    @Test
    void shouldThrowValidationExceptionWhenCreateScoreBecauseIsSmallerThan000() {
        var score = -0.01;

        assertThatThrownBy(() -> new Score(score))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must be greater than or equal to 0.00, value=%s".formatted(score));
    }

    @DisplayName("Should throw ValidationException when create Score because is larger than 10.00")
    @Test
    void shouldThrowValidationExceptionWhenCreateScoreBecauseIsLargerThan1000() {
        var score = 10.01;

        assertThatThrownBy(() -> new Score(score))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must be less than or equal to 10.00, value=%s".formatted(score));
    }

}