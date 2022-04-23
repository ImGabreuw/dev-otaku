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

class ProducerTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = Faker.instance();
    }

    @DisplayName("Should create Producer")
    @Test
    void shouldCreateProducer() {
        var producer = faker.company().name();

        Producer underTest = new Producer(producer);

        assertThat(underTest.value()).isEqualTo(producer);
    }

    @DisplayName("Should throw ValidationException when create Producer because is null, empty or blank")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateProducerBecauseIsNullEmptyOrBlank(String producer) {
        assertThatThrownBy(() -> new Producer(producer))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be blank, value=%s".formatted(producer));
    }

    @DisplayName("Should throw ValidationException when create Producer because has size larger than 255")
    @Test
    void shouldThrowValidationExceptionWhenCreateProducerBecauseHasSizeLargerThan255() {
        var producer = "a".repeat(256);

        assertThatThrownBy(() -> new Producer(producer))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=size must be between 0 and 255, value=%s".formatted(producer));
    }


}