package br.com.devotaku.userservice.shared.exceptions;

public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Object... values) {
        super(String.format(message, values));
    }

}
