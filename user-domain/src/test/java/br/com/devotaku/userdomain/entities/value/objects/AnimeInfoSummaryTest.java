package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.exception.ValidationException;
import br.com.devotaku.userdomain.entities.AnimeInfoSummary;
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
        assertThat(underTest.getTitle()).isEqualTo(title);
        assertThat(underTest.getScore()).isEqualTo(score);
        assertThat(underTest.getImageUrl()).isEqualTo(imageUrl);
        assertThat(underTest.getEpisodesSeen()).isEqualTo(episodesSeen);
        assertThat(underTest.getTotalEpisodes()).isEqualTo(totalEpisodes);
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
                        "A classe Title teve suas constraints violadas. [Field[fieldName=value, message=O campo 'Title' é obrigatório, value=%s]]",
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
                        "A classe Score teve suas constraints violadas. [Field[fieldName=value, message=O campo 'Score' deve conter um número entre 0.00 e 10.00, value=%s]]",
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
                .hasMessage(String.format(
                        "A classe Image teve suas constraints violadas. [Field[fieldName=url, message=O campo 'Url' é obrigatório, value=%s]]",
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
                        "A classe Image teve suas constraints violadas. [Field[fieldName=url, message=O campo 'Url' deve conter uma URL válida, value=%s]]",
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
                .hasMessageContaining(String.format(
                        "Field[fieldName=url, message=O campo 'Url' é obrigatório, value=%s]",
                        imageUrl
                ))
                .hasMessageContaining(String.format(
                        "Field[fieldName=url, message=O campo 'Url' deve conter uma URL válida, value=%s]",
                        imageUrl
                ));
    }

}