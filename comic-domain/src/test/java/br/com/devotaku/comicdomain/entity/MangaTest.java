package br.com.devotaku.comicdomain.entity;

import br.com.devotaku.comicdomain.entity.builder.MangaBuilder;
import br.com.devotaku.comicdomain.entity.enums.Genre;
import br.com.devotaku.comicdomain.entity.enums.Status;
import br.com.devotaku.comicdomain.entity.value.object.AlternativeName;
import br.com.devotaku.comicdomain.entity.value.object.Author;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.shared.validation.exception.ValidationException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static br.com.devotaku.comicdomain.entity.enums.Genre.*;
import static br.com.devotaku.comicdomain.entity.enums.Status.PUBLISHING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MangaTest {

    @Test
    void shouldCreateManga() {
        // given
        Identifier id = new Identifier(1L);
        String title = "One Piece";
        List<Author> authors = List.of(new Author("Oda Eiichiro"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, COMEDY, FANTASY);
        String description = "One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!";
        Status status = PUBLISHING;
        double score = 9.56;
        List<AlternativeName> alternativesName = List.of(new AlternativeName("ONE PIECE"));

        // when
        Manga underTestManga = MangaBuilder.builder()
                .id(id)
                .title(title)
                .alternativeNames(alternativesName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThat(underTestManga.getId()).isEqualTo(id);
        assertThat(underTestManga.getTitle()).isEqualTo(title);
        assertThat(underTestManga.getAuthors()).containsExactlyElementsOf(authors);
        assertThat(underTestManga.getGenres()).containsExactlyElementsOf(genres);
        assertThat(underTestManga.getDescription()).isEqualTo(description);
        assertThat(underTestManga.getStatus()).isEqualTo(status);
        assertThat(underTestManga.getScore()).isEqualTo(score);
        assertThat(underTestManga.getAlternativeNames()).containsExactlyElementsOf(alternativesName);
    }

    @ValueSource(strings = " ")
    @NullAndEmptySource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateMangaBecauseTitleIsNullOrEmptyOrBlank(String title) {
        // given
        Identifier id = new Identifier(1L);
        List<AlternativeName> alternativesName = List.of(new AlternativeName("ONE PIECE"));
        List<Author> authors = List.of(new Author("Oda Eiichiro"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, COMEDY, FANTASY);
        String description = "One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!";
        Status status = PUBLISHING;
        double score = 9.56;

        // when
        ThrowableAssert.ThrowingCallable underTestManga = () -> MangaBuilder.builder()
                .id(id)
                .alternativeNames(alternativesName)
                .title(title)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManga)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manga.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateMangaBecauseAuthorsIsNullOrHasLessThanOne(List<Author> authors) {
        // given
        Identifier id = new Identifier(1L);
        String title = "One Piece";
        List<Genre> genres = List.of(ACTION, ADVENTURE, COMEDY, FANTASY);
        String description = "One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!";
        Status status = PUBLISHING;
        double score = 9.56;
        List<AlternativeName> alternativesName = List.of(new AlternativeName("ONE PIECE"));

        // when
        ThrowableAssert.ThrowingCallable underTestManga = () -> MangaBuilder.builder()
                .id(id)
                .title(title)
                .alternativeNames(alternativesName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManga)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manga.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateMangaBecauseGenresIsNullOrHasLessThanOne(List<Genre> genres) {
        // given
        Identifier id = new Identifier(1L);
        String title = "One Piece";
        List<Author> authors = List.of(new Author("Oda Eiichiro"));
        String description = "One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!";
        Status status = PUBLISHING;
        double score = 9.56;
        List<AlternativeName> alternativesName = List.of(new AlternativeName("ONE PIECE"));

        // when
        ThrowableAssert.ThrowingCallable underTestManga = () -> MangaBuilder.builder()
                .id(id)
                .title(title)
                .alternativeNames(alternativesName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManga)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manga.class.getSimpleName());
    }

    @ValueSource(strings = " ")
    @NullAndEmptySource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateMangaBecauseDescriptionIsNullOrEmptyOrBlank(String description) {
        // given
        Identifier id = new Identifier(1L);
        String title = "One Piece";
        List<Author> authors = List.of(new Author("Oda Eiichiro"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, COMEDY, FANTASY);
        Status status = PUBLISHING;
        double score = 9.56;
        List<AlternativeName> alternativesName = List.of(new AlternativeName("ONE PIECE"));

        // when
        ThrowableAssert.ThrowingCallable underTestManga = () -> MangaBuilder.builder()
                .id(id)
                .title(title)
                .alternativeNames(alternativesName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManga)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manga.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateMangaBecauseStatusInNull(Status status) {
        // given
        Identifier id = new Identifier(1L);
        String title = "One Piece";
        List<Author> authors = List.of(new Author("Oda Eiichiro"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, COMEDY, FANTASY);
        String description = "One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!";
        double score = 9.56;
        List<AlternativeName> alternativesName = List.of(new AlternativeName("ONE PIECE"));

        // when, then
        ThrowableAssert.ThrowingCallable underTestManga = () -> MangaBuilder.builder()
                .id(id)
                .title(title)
                .alternativeNames(alternativesName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        assertThatThrownBy(underTestManga)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manga.class.getSimpleName());

    }

    @ArgumentsSource(ScoreArgumentsProvider.class)
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateMangaBecauseScoreHasMoreThan2IntegerAndFractionOrIsLessThan0orIsGraderThan10(Double score) {
        // given
        Identifier id = new Identifier(1L);
        String title = "One Piece";
        List<Author> authors = List.of(new Author("Oda Eiichiro"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, COMEDY, FANTASY);
        String description = "One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!";
        Status status = PUBLISHING;
        List<AlternativeName> alternativesName = List.of(new AlternativeName("ONE PIECE"));

        // when
        ThrowableAssert.ThrowingCallable underTestManga = () -> MangaBuilder.builder()
                .id(id)
                .title(title)
                .alternativeNames(alternativesName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManga)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manga.class.getSimpleName());
    }

}