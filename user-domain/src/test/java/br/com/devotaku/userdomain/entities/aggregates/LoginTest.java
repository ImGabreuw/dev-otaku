package br.com.devotaku.userdomain.entities.aggregates;

import br.com.devotaku.shared.validation.exception.ValidationException;
import br.com.devotaku.userdomain.entities.Login;
import br.com.devotaku.userdomain.entities.exceptions.LoginException;
import br.com.devotaku.userdomain.utils.email.EmailUtils;
import br.com.devotaku.userdomain.utils.email.InvalidEmailSource;
import br.com.devotaku.userdomain.utils.login.LoginSource;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LoginTest {

    @ParameterizedTest
    @LoginSource
    void shouldCreateLogin(String email, String password) {
        // when
        var underTest = new Login(email, password);

        // then
        assertThat(underTest.getEmail()).isEqualTo(email);
        assertThat(underTest.getPassword()).isEqualTo(password);
    }

    @Test
    void shouldChangePassword() {
        // given
        var email = "devotaku@gmail.com";
        var password = "devotaku1234";
        var newPassword = "devotaku12345";

        var login = new Login(email, password);

        // when
        login.changePassword(newPassword);

        // then
        assertThat(login.getPassword()).isEqualTo(newPassword);
    }

    @Test
    void shouldThrowLoginExceptionWhenChangePasswordBecausePasswordAndNewPasswordIsTheSame() {
        // given
        var email = "devotaku@gmail.com";
        var password = "devotaku1234";
        var newPassword = "devotaku1234";

        var login = new Login(email, password);

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> login.changePassword(newPassword);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(LoginException.class)
                .hasMessage("As senhas são iguais.");
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowValidationExceptionWhenCreateLoginBecauseEmailIsNull(String email) {
        // given
        var password = "devotaku1234";

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Login(email, password);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Login teve suas constraints violadas. [Field[fieldName=email, message=O campo 'Email' não deve estar em branco, value=%s]]",
                        email
                ));
    }

    @ParameterizedTest
    @InvalidEmailSource
    void shouldThrowValidationExceptionWhenCreateLoginBecauseEmailIsInvalid(String email) {
        // given
        var password = "devotaku1234";

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Login(email, password);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Login teve suas constraints violadas. [Field[fieldName=email, message=O campo 'Email' deve conter um email válido, value=%s]]",
                        email
                ));
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowValidationExceptionWhenCreateLoginBecausePasswordIsNull(String password) {
        // given
        var email = EmailUtils.getRandomValidEmail();

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Login(email, password);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Login teve suas constraints violadas. [Field[fieldName=password, message=O campo 'Password' é obrigatório, value=%s]]",
                        password
                ));
    }

    @Test
    void shouldThrowValidationExceptionWhenCreateLoginBecausePasswordLengthIsLessThan5() {
        // given
        var email = EmailUtils.getRandomValidEmail();
        var password = "1234";

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Login(email, password);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Login teve suas constraints violadas. [Field[fieldName=password, message=O campo 'Password' deve conter um valor de tamanho de {1} a {2} caracteres, value=%s]]",
                        password
                ));
    }

    @Test
    void shouldThrowValidationExceptionWhenCreateLoginBecausePasswordLengthIsGreaterThan20() {
        // given
        var email = EmailUtils.getRandomValidEmail();
        var password = "123456789012345678901";

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Login(email, password);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Login teve suas constraints violadas. [Field[fieldName=password, message=O campo 'Password' deve conter um valor de tamanho de {1} a {2} caracteres, value=%s]]",
                        password
                ));
    }

}