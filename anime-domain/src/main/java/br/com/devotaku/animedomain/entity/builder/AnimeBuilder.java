package br.com.devotaku.animedomain.entity.builder;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.entity.enums.Genre;
import br.com.devotaku.animedomain.entity.enums.SourceType;
import br.com.devotaku.animedomain.entity.enums.Status;
import br.com.devotaku.animedomain.entity.value.object.AlternativeName;
import br.com.devotaku.animedomain.entity.value.object.Identifier;
import br.com.devotaku.animedomain.entity.value.object.Producer;
import br.com.devotaku.animedomain.entity.value.object.Studio;
import br.com.devotaku.shared.date.DateParser;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class AnimeBuilder {

    private Identifier id;

    private String title;

    private Set<AlternativeName> alternativeNames;

    private String description;

    private Double score;

    private Integer episodes;

    private Status status;

    private LocalDate launchedAt;

    private LocalDate endedAt;

    private Set<Producer> producers;

    private Set<Studio> studios;

    private SourceType source;

    private List<Genre> genres;

    public static AnimeBuilder builder() {
        return new AnimeBuilder();
    }

    public AnimeBuilder id(Long id) {
        this.id = new Identifier(id);
        return this;
    }

    public AnimeBuilder id(Identifier id) {
        this.id = id;
        return this;
    }

    public AnimeBuilder title(String title) {
        this.title = title;
        return this;
    }

    public AnimeBuilder alternativeNames(AlternativeName... alternativeNames) {
        this.alternativeNames = new HashSet<>(Arrays.asList(alternativeNames));
        return this;
    }

    public AnimeBuilder alternativeNames(Set<AlternativeName> alternativeNames) {
        this.alternativeNames = alternativeNames;
        return this;
    }

    public AnimeBuilder description(String description) {
        this.description = description;
        return this;
    }

    public AnimeBuilder score(Double score) {
        this.score = score;
        return this;
    }

    public AnimeBuilder episodes(Integer episodes) {
        this.episodes = episodes;
        return this;
    }

    public AnimeBuilder status(Status status) {
        this.status = status;
        return this;
    }

    public AnimeBuilder launchedAt(LocalDate launchedAt) {
        this.launchedAt = launchedAt;
        return this;
    }

    public AnimeBuilder launchedAt(String launchedAt) {
        this.launchedAt = DateParser.parse(launchedAt);
        return this;
    }

    public AnimeBuilder endedAt(LocalDate endedAt) {
        this.endedAt = endedAt;
        return this;
    }

    public AnimeBuilder endedAt(String endedAt) {
        this.endedAt = DateParser.parse(endedAt);
        return this;
    }

    public AnimeBuilder producers(Producer... producers) {
        this.producers = new HashSet<>(Arrays.asList(producers));
        return this;
    }

    public AnimeBuilder producers(Set<Producer> producers) {
        this.producers = producers;
        return this;
    }

    public AnimeBuilder studios(Studio... studios) {
        this.studios = new HashSet<>(Arrays.asList(studios));
        return this;
    }

    public AnimeBuilder studios(Set<Studio> studios) {
        this.studios = studios;
        return this;
    }

    public AnimeBuilder source(SourceType source) {
        this.source = source;
        return this;
    }

    public AnimeBuilder genres(Genre... genres) {
        this.genres = Arrays.asList(genres);
        return this;
    }

    public AnimeBuilder genres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public Anime build() {
        return new Anime(id, title, alternativeNames, description, score, episodes, status, launchedAt, endedAt, producers, studios, source, genres);
    }

}
