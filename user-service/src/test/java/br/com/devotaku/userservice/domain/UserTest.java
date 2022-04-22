package br.com.devotaku.userservice.domain;

import br.com.devotaku.userservice.domain.value.objects.Email;
import br.com.devotaku.userservice.domain.value.objects.Name;
import br.com.devotaku.userservice.domain.value.objects.Password;
import br.com.devotaku.userservice.domain.value.objects.Username;
import br.com.devotaku.userservice.shared.validation.SelfValidation;
import br.com.devotaku.userservice.utils.PasswordGenerator;
import br.com.devotaku.userservice.utils.annotation.BlankSource;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = new Faker();
    }

    @DisplayName("Should create User")
    @Test
    void shouldCreateUser() {
        Name name = new Name(faker.name().fullName());
        Username username = new Username(faker.name().username());
        Email email = new Email(faker.internet().emailAddress());
        Password password = new Password(PasswordGenerator.generateStrongPassword(12));

        User underTest = User.builder()
                .name(name)
                .username(username)
                .email(email)
                .password(password)
                .build();

        assertThat(underTest.getName()).isEqualTo(name);
        assertThat(underTest.getUsername()).isEqualTo(username);
        assertThat(underTest.getEmail()).isEqualTo(email);
        assertThat(underTest.getPassword()).isEqualTo(password);
    }

    @DisplayName("Should throw ValidationException when create User because Name is invalid")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateUserBecauseNameIsInvalid(String name) {
        assertThatThrownBy(() -> User.builder()
                .name(new Name(name))
                .username(new Username(faker.name().username()))
                .email(new Email(faker.internet().emailAddress()))
                .password(new Password(PasswordGenerator.generateStrongPassword(12)))
                .build())
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be blank, value=%s".formatted(name));
    }

    @DisplayName("Should throw ValidationException when create User because Username is invalid")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateUserBecauseUsernameIsInvalid(String username) {
        assertThatThrownBy(() -> User.builder()
                .name(new Name(faker.name().fullName()))
                .username(new Username(username))
                .email(new Email(faker.internet().emailAddress()))
                .password(new Password(PasswordGenerator.generateStrongPassword(12)))
                .build())
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be blank, value=%s".formatted(username));
    }

    @DisplayName("Should throw ValidationException when create User because Email is invalid")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateUserBecauseEmailIsInvalid(String email) {
        assertThatThrownBy(() -> User.builder()
                .name(new Name(faker.name().fullName()))
                .username(new Username(faker.name().username()))
                .email(new Email(email))
                .password(new Password(PasswordGenerator.generateStrongPassword(12)))
                .build())
                .isInstanceOf(SelfValidation.ValidationException.class)
                .hasMessageContaining("fieldName=value, message=must not be blank, value=%s".formatted(email));
    }

    @DisplayName("Should throw ValidationException when create User because Password is invalid")
    @BlankSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateUserBecausePasswordIsInvalid(String password) {
        assertThatThrownBy(() -> User.builder()
                .name(new Name(faker.name().fullName()))
                .username(new Username(faker.name().username()))
                .email(new Email(faker.internet().emailAddress()))
                .password(new Password(password))
                .build())
                .isInstanceOf(SelfValidation.ValidationException.class);
    }

}