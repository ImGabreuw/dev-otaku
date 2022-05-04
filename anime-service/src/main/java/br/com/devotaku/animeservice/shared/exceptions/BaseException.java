package br.com.devotaku.animeservice.shared.exceptions;

public abstract class BaseException extends RuntimeException {

    protected BaseException(String message) {
        super(message);
    }

    protected BaseException(String message, Object... values) {
        super(message.formatted(values));
    }

    public abstract int getStatusCode();

}
