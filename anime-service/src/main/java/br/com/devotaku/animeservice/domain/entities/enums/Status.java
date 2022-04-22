package br.com.devotaku.animeservice.domain.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Status {

    FINISHED("Finished"),
    PUBLISHING("Publishing");

    private final String description;

}
