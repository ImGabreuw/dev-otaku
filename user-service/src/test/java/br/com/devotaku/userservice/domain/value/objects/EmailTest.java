package br.com.devotaku.userservice.domain.value.objects;

import br.com.devotaku.userservice.shared.validation.SelfValidation;
import br.com.devotaku.userservice.utils.annotation.BlankSource;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = new Faker();
    }

    @DisplayName("Should create Email")
    @Test
    void shouldCreateEmail() {
        var email = faker.internet().emailAddress();

        Email underTest = new Email(email);

        assertThat(underTest.value()).isEqualTo(email);
    }

    @DisplayName("Should throw ValidationException when create Email because is null or empty or blank")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateEmailBecauseIsNullOrEmptyOrBlank(String email) {
        assertThatThrownBy(() -> new Email(email))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be blank, value=%s".formatted(email));
    }

    @DisplayName("Should throw ValidationException when create Email because is malformed email")
    @Test
    void shouldThrowValidationExceptionWhenCreateEmailBecauseIsMalformedEmail() {
        var email = faker.internet().emailAddress().replace("@", "");

        assertThatThrownBy(() -> new Email(email))
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must be a well-formed email address, value=%s".formatted(email));
    }

}