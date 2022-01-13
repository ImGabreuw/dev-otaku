package br.com.devotaku.animedomain.entity;

import br.com.devotaku.animedomain.entity.builder.AnimeBuilder;
import br.com.devotaku.animedomain.entity.enums.Genre;
import br.com.devotaku.animedomain.entity.enums.SourceType;
import br.com.devotaku.animedomain.entity.enums.Status;
import br.com.devotaku.animedomain.entity.value.object.AlternativeName;
import br.com.devotaku.animedomain.entity.value.object.Identifier;
import br.com.devotaku.animedomain.entity.value.object.Producer;
import br.com.devotaku.animedomain.entity.value.object.Studio;
import br.com.devotaku.animedomain.utils.NullEmptyAndBlankSource;
import br.com.devotaku.animedomain.utils.arguments.provider.genre.GenreArguments;
import br.com.devotaku.animedomain.utils.arguments.provider.producer.ProducerArguments;
import br.com.devotaku.animedomain.utils.arguments.provider.studio.StudioArguments;
import br.com.devotaku.shared.date.DateParser;
import br.com.devotaku.shared.validation.exception.ValidationException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static br.com.devotaku.animedomain.entity.enums.Genre.ACTION;
import static br.com.devotaku.animedomain.entity.enums.Genre.SUPERNATURAL;
import static br.com.devotaku.animedomain.entity.enums.SourceType.MANGA;
import static br.com.devotaku.animedomain.entity.enums.Status.FINISHED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnimeTest {

    @Test
    void shouldCreateAnime() {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        Anime underTest = AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThat(underTest.getId()).isEqualTo(id);
        assertThat(underTest.getTitle()).isEqualTo(title);
        assertThat(underTest.getAlternativeNames()).contains(alternativeNames);
        assertThat(underTest.getDescription()).isEqualTo(description);
        assertThat(underTest.getScore()).isEqualTo(score);
        assertThat(underTest.getEpisodes()).isEqualTo(episodes);
        assertThat(underTest.getLaunchedAt()).isEqualTo(launchedAt);
        assertThat(underTest.getEndedAt()).isEqualTo(endedAt);
        assertThat(underTest.getProducers()).contains(producers);
        assertThat(underTest.getStudios()).contains(studios);
        assertThat(underTest.getStatus()).isEqualTo(status);
        assertThat(underTest.getSource()).isEqualTo(source);
        assertThat(underTest.getGenres()).contains(genres);
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseTitleIsInvalid(String title) {
        // given
        Identifier id = new Identifier(1L);
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseDescriptionIsInvalid(String description) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 11})
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseScoreIsInvalid(Double score) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {-1, 0})
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseEpisodesIsInvalid(Integer episodes) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseStatusIsInvalid(Status status) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseLaunchedAtIsInvalid(LocalDate launchedAt) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseEndedAtIsInvalid(LocalDate endedAt) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @ProducerArguments
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseProducersIsInvalid(Set<Producer> producers) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @StudioArguments
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseStudiosIsInvalid(Set<Studio> studios) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseSourceIsInvalid(SourceType source) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @GenreArguments
    void shouldThrowValidationExceptionWhenCreateAnimeBecauseGenresIsInvalid(List<Genre> genres) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> AnimeBuilder.builder()
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
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

}