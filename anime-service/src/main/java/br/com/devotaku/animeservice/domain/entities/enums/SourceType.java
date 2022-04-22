package br.com.devotaku.animeservice.domain.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SourceType {

    MANGA("Manga"),
    MANHWA("Manhwa"),
    WEBTOON("WebToon");

    private final String description;

}
