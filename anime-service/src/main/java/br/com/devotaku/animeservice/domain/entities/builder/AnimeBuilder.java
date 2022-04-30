package br.com.devotaku.animeservice.domain.entities.builder;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.entities.enums.SourceType;
import br.com.devotaku.animeservice.domain.entities.enums.Status;
import br.com.devotaku.animeservice.domain.entities.value.objects.*;
import br.com.devotaku.animeservice.shared.date.DateParser;
import br.com.devotaku.animeservice.shared.generators.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class AnimeBuilder {

    private Identifier id;

    private Title title;

    private Set<AlternativeName> alternativeNames;

    private Description description;

    private Score score;

    private Episodes episodes;

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

    public AnimeBuilder id() {
        this.id = IdentifierUtils.getInstance().generateIdentifier();
        return this;
    }

    public AnimeBuilder id(Long id) {
        this.id = new Identifier(id);
        return this;
    }

    public AnimeBuilder id(Identifier id) {
        this.id = id;
        return this;
    }

    public AnimeBuilder title() {
        this.title = TitleUtils.getInstance().generateTitle();
        return this;
    }

    public AnimeBuilder title(String title) {
        this.title = new Title(title);
        return this;
    }

    public AnimeBuilder title(Title title) {
        this.title = title;
        return this;
    }

    public AnimeBuilder alternativeNames() {
        this.alternativeNames = AlternativeNameUtils.getInstance().generateAlternativeNameSequence();
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

    public AnimeBuilder description() {
        this.description = DescriptionUtils.getInstance().generateDescription();
        return this;
    }

    public AnimeBuilder description(String description) {
        this.description = new Description(description);
        return this;
    }

    public AnimeBuilder description(Description description) {
        this.description = description;
        return this;
    }

    public AnimeBuilder score() {
        this.score = ScoreUtils.getInstance().generateScore();
        return this;
    }

    public AnimeBuilder score(Double score) {
        this.score = new Score(score);
        return this;
    }

    public AnimeBuilder score(Score score) {
        this.score = score;
        return this;
    }

    public AnimeBuilder episodes() {
        this.episodes = EpisodesUtils.getInstance().generateEpisodes();
        return this;
    }

    public AnimeBuilder episodes(Integer episodes) {
        this.episodes = new Episodes(episodes);
        return this;
    }

    public AnimeBuilder episodes(Episodes episodes) {
        this.episodes = episodes;
        return this;
    }

    public AnimeBuilder status() {
        this.status = StatusUtils.getInstance().generateStatus();
        return this;
    }

    public AnimeBuilder status(Status status) {
        this.status = status;
        return this;
    }

    public AnimeBuilder launchedAt() {
        this.launchedAt = LocalDateUtils.getInstance().generateLaunchedAt();
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

    public AnimeBuilder endedAt() {
        this.endedAt = LocalDateUtils.getInstance().generateEndedAt(launchedAt);
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

    public AnimeBuilder producers() {
        this.producers = ProducerUtils.getInstance().generateProducerSequence();
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

    public AnimeBuilder studios() {
        this.studios = StudioUtils.getInstance().generateStudioSequence();
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

    public AnimeBuilder source() {
        this.source = SourceTypeUtils.getInstance().generateSourceType();
        return this;
    }

    public AnimeBuilder source(SourceType source) {
        this.source = source;
        return this;
    }

    public AnimeBuilder genres() {
        this.genres = GenreUtils.getInstance().generateGenres();
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
