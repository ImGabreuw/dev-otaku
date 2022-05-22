package br.com.devotaku.animeservice.shared.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class AnimeNotFoundException extends BaseException {

    public AnimeNotFoundException(String message, Object... values) {
        super(message, values);
    }

    @Override
    public int getStatusCode() {
        return NOT_FOUND.value();
    }

    @Getter
    @RequiredArgsConstructor
    public enum MessageTemplate {
        ANIME_NOT_FOUND_BY_ID("Anime not fount by id (%s)."),
        ANIME_NOT_FOUND_BY_TITLE_OR_ALTERNATIVE_NAMES("There is no anime named (%s)."),
        DO_NOT_EXIST_ANY_ANIME_WITH_PRODUCERS("Do not exist any anime with producer named (%s)."),
        ANIME_NOT_FOUND_BY_STUDIO("Do not exist any anime with studio named (%s).");

        private final String message;
    }

}
