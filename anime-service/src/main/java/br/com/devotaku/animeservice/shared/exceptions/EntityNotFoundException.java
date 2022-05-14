package br.com.devotaku.animeservice.shared.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(String message, Object... values) {
        super(message, values);
    }

    @Override
    public int getStatusCode() {
        return NOT_FOUND.value();
    }

    @Getter
    @RequiredArgsConstructor
    public enum MessageTemplate {
        ENTITY_NOT_FOUND_BY_ID("Entity not fount by id (%s).");

        private final String message;
    }

}
