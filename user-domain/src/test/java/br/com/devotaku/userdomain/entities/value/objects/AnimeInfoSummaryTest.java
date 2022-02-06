package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.exception.ValidationException;
import br.com.devotaku.userdomain.utils.NullEmptyAndBlankSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnimeInfoSummaryTest {

    @Test
    void shouldCreateAnimeInfoSummary() {
        // given
        var title = "Kimetsu no Yaiba";
        var score = 8.57;
        var imageUrl = "https://cdn.myanimelist.net/images/anime/1286/99889.jpg";

        var episodesSeen = 5;
        var totalEpisodes = 26;

        // when
        var underTest = AnimeInfoSummary.create(title, score, imageUrl, episodesSeen, totalEpisodes);

        // then
        assertThat(underTest.title()).isEqualTo(title);
        assertThat(underTest.score()).isEqualTo(score);
        assertThat(underTest.imageUrl()).isEqualTo(imageUrl);
        assertThat(underTest.progress().seen()).isEqualTo(episodesSeen);
        assertThat(underTest.progress().total()).isEqualTo(totalEpisodes);
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowValidationExceptionWhenCreateAnimeInfoSummaryBecauseTitleIsInvalid(String title) {
        // given
        var score = 8.57;
        var imageUrl = "https://cdn.myanimelist.net/images/anime/1286/99889.jpg";

        var episodesSeen = 5;
        var totalEpisodes = 26;

        // when, then
        assertThatThrownBy(() -> AnimeInfoSummary.create(
                title,
                score,
                imageUrl,
                episodesSeen,
                totalEpisodes
        ))
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe AnimeInfoSummary teve suas constraints violadas. [Field[fieldName=title, message=O campo 'Title' é obrigatório, value=%s]]",
                        title
                ));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.01, 10.01})
    void shouldThrowValidationExceptionWhenCreateAnimeInfoSummaryBecauseScoreIsInvalid(Double score) {
        // given
        var title = "Kimetsu no Yaiba";
        var imageUrl = "https://cdn.myanimelist.net/images/anime/1286/99889.jpg";

        var episodesSeen = 5;
        var totalEpisodes = 26;

        // when, then
        assertThatThrownBy(() -> AnimeInfoSummary.create(
                title,
                score,
                imageUrl,
                episodesSeen,
                totalEpisodes
        ))
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe AnimeInfoSummary teve suas constraints violadas. [Field[fieldName=score, message=O campo 'Score' deve conter um número entre 0.00 e 10.00, value=%s]]",
                        score
                ));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void shouldThrowValidationExceptionWhenCreateAnimeInfoSummaryBecauseImageUrlIsInvalid(String imageUrl) {
        // given
        var title = "Kimetsu no Yaiba";
        var score = 8.57;

        var episodesSeen = 5;
        var totalEpisodes = 26;

        // when, then
        assertThatThrownBy(() -> AnimeInfoSummary.create(
                title,
                score,
                imageUrl,
                episodesSeen,
                totalEpisodes
        ))
                .isInstanceOf(ValidationException.class)
                .hasMessageStartingWith(String.format(
                        "A classe AnimeInfoSummary teve suas constraints violadas. [Field[fieldName=imageUrl, message=O campo 'ImageUrl' é obrigatório, value=%s]",
                        imageUrl
                ));
    }

    @ParameterizedTest
    @ValueSource(strings = "/path/to/image")
    void shouldThrowValidationExceptionWhenCreateAnimeInfoSummaryBecauseImageUrlIsMalFormed(String imageUrl) {
        // given
        var title = "Kimetsu no Yaiba";
        var score = 8.57;

        var episodesSeen = 5;
        var totalEpisodes = 26;

        // when, then
        assertThatThrownBy(() -> AnimeInfoSummary.create(
                title,
                score,
                imageUrl,
                episodesSeen,
                totalEpisodes
        ))
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe AnimeInfoSummary teve suas constraints violadas. [Field[fieldName=imageUrl, message=O campo 'ImageUrl' deve conter uma URL válida, value=%s]]",
                        imageUrl
                ));
    }

    @Test
    void shouldThrowValidationExceptionWhenCreateAnimeInfoSummaryBecauseImageUrlIsBlank() {
        // given
        var title = "Kimetsu no Yaiba";
        var score = 8.57;
        var imageUrl = "   ";

        var episodesSeen = 5;
        var totalEpisodes = 26;

        // when, then
        assertThatThrownBy(() -> AnimeInfoSummary.create(
                title,
                score,
                imageUrl,
                episodesSeen,
                totalEpisodes
        ))
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe AnimeInfoSummary teve suas constraints violadas. [Field[fieldName=imageUrl, message=O campo 'ImageUrl' deve conter uma URL válida, value=%s], Field[fieldName=imageUrl, message=O campo 'ImageUrl' é obrigatório, value=%s]]",
                        imageUrl,
                        imageUrl
                ));
    }

}