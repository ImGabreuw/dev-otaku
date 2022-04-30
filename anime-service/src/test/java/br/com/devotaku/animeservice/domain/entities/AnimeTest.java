package br.com.devotaku.animeservice.domain.entities;

import br.com.devotaku.animeservice.domain.entities.builder.AnimeBuilder;
import br.com.devotaku.animeservice.shared.generators.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class AnimeTest {

    private static IdentifierUtils identifierUtils;
    private static TitleUtils titleUtils;
    private static AlternativeNameUtils alternativeNameUtils;
    private static DescriptionUtils descriptionUtils;
    private static StatusUtils statusUtils;
    private static ScoreUtils scoreUtils;
    private static EpisodesUtils episodesUtils;
    private static LocalDateUtils localDateUtils;
    private static ProducerUtils producerUtils;
    private static StudioUtils studioUtils;
    private static SourceTypeUtils sourceTypeUtils;
    private static GenreUtils genreUtils;

    @BeforeAll
    static void beforeAll() {
        identifierUtils = IdentifierUtils.getInstance();
        titleUtils = TitleUtils.getInstance();
        alternativeNameUtils = AlternativeNameUtils.getInstance();
        descriptionUtils = DescriptionUtils.getInstance();
        statusUtils = StatusUtils.getInstance();
        scoreUtils = ScoreUtils.getInstance();
        episodesUtils = EpisodesUtils.getInstance();
        localDateUtils = LocalDateUtils.getInstance();
        producerUtils = ProducerUtils.getInstance();
        studioUtils = StudioUtils.getInstance();
        sourceTypeUtils = SourceTypeUtils.getInstance();
        genreUtils = GenreUtils.getInstance();
    }

    @DisplayName("Should create Anime")
    @Test
    void shouldCreateAnime() {
        var id = identifierUtils.generateIdentifier();
        var title = titleUtils.generateTitle();
        var alternativeNames = alternativeNameUtils.generateAlternativeNameSequence();
        var description = descriptionUtils.generateDescription();
        var score = scoreUtils.generateScore();
        var episodes = episodesUtils.generateEpisodes();
        var status = statusUtils.generateStatus();
        var launchedAt = localDateUtils.generateLaunchedAt();
        var endedAt = localDateUtils.generateEndedAt(launchedAt);
        var producers = producerUtils.generateProducerSequence();
        var studios = studioUtils.generateStudioSequence();
        var sourceType = sourceTypeUtils.generateSourceType();
        var genres = genreUtils.generateGenres();

        var underTest = AnimeBuilder.builder()
                .id(id)
                .title(title)
                .alternativeNames(alternativeNames)
                .description(description)
                .score(score)
                .episodes(episodes)
                .status(status)
                .launchedAt(launchedAt)
                .endedAt(endedAt)
                .producers(producers)
                .studios(studios)
                .source(sourceType)
                .genres(genres)
                .build();

        assertThat(underTest.getId())
                .isNotNull()
                .isEqualTo(id);

        assertThat(underTest.getTitle())
                .isNotNull()
                .isEqualTo(title);

        assertThat(underTest.getAlternativeNames())
                .isEqualTo(alternativeNames);

        assertThat(underTest.getDescription())
                .isNotNull()
                .isEqualTo(description);

        assertThat(underTest.getScore())
                .isNotNull()
                .isEqualTo(score);

        assertThat(underTest.getEpisodes())
                .isNotNull()
                .isEqualTo(episodes);

        assertThat(underTest.getStatus())
                .isNotNull()
                .isEqualTo(status);

        assertThat(underTest.getLaunchedAt())
                .isNotNull()
                .isEqualTo(launchedAt);

        assertThat(underTest.getEndedAt())
                .isEqualTo(Optional.ofNullable(endedAt));

        assertThat(underTest.getProducers())
                .hasSize(producers.size())
                .isEqualTo(producers);

        assertThat(underTest.getStudios())
                .hasSize(studios.size())
                .isEqualTo(studios);

        assertThat(underTest.getSource())
                .isNotNull()
                .isEqualTo(sourceType);

        assertThat(underTest.getGenres())
                .hasSize(genres.size())
                .isEqualTo(genres);
    }

    @DisplayName("Should create Anime when AlternativeNames is null")
    @Test
    void shouldCreateAnimeWhenAlternativeNamesIsNull() {
        var underTest = AnimeBuilder.builder()
                .id()
                .title()
                .description()
                .score()
                .episodes()
                .status()
                .launchedAt()
                .endedAt()
                .producers()
                .studios()
                .source()
                .genres()
                .build();

        assertThat(underTest.getAlternativeNames())
                .isEmpty();
    }

    @DisplayName("Should create anime when EndedAt is null")
    @Test
    void shouldCreateAnimeWhenEndedAtIsNull() {
        var underTest = AnimeBuilder.builder()
                .id()
                .title()
                .alternativeNames()
                .description()
                .score()
                .episodes()
                .status()
                .launchedAt()
                .producers()
                .studios()
                .source()
                .genres()
                .build();

        assertThat(underTest.getEndedAt())
                .isEmpty();
    }

}