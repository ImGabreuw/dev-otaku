package br.com.devotaku.userdomain.entities.exceptions;

public class LoginException extends RuntimeException {

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Object... values) {
        super(String.format(message, values));
    }

}
