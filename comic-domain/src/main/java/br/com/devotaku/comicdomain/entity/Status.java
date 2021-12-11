package br.com.devotaku.comicdomain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Status {

    FINISHED("Finished"),
    PUBLISHING("Publishing");

    private final String description;

}
