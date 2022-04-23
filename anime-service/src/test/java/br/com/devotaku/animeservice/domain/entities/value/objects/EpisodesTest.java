package br.com.devotaku.animeservice.domain.entities.value.objects;

import br.com.devotaku.animeservice.shared.validation.SelfValidation;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EpisodesTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = Faker.instance();
    }

    @DisplayName("Should create Episodes")
    @Test
    void shouldCreateEpisodes() {
        var episodes = faker.number().randomDigitNotZero();

        Episodes underTest = new Episodes(episodes);

        assertThat(underTest.value()).isEqualTo(episodes);
    }

    @DisplayName("Should throw ValidationException when create Episodes because is null")
    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateEpisodesBecauseIsNull(Integer episodes) {
        assertThatThrownBy(() -> new Episodes(episodes))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("Field[fieldName=value, message=must not be null, value=%s".formatted(episodes));
    }

    @DisplayName("Should throw ValidationException when create Episodes because is negative or zero")
    @ValueSource(ints = {-1, 0})
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateEpisodesBecauseIsNegativeOrZero(Integer episodes) {
        assertThatThrownBy(() -> new Episodes(episodes))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must be greater than 0, value=%s".formatted(episodes));
    }

}