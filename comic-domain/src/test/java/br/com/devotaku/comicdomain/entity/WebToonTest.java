package br.com.devotaku.comicdomain.entity;

import br.com.devotaku.comicdomain.entity.builder.WebToonBuilder;
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

import static br.com.devotaku.comicdomain.entity.Genre.*;
import static br.com.devotaku.comicdomain.entity.Status.PUBLISHING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WebToonTest {

    @Test
    void shouldCreateWebToon() {
        // given
        Identifier id = new Identifier(1L);
        String title = "Solo Leveling";
        List<Author> authors = List.of(new Author("Jang Sung-Lak"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, SHOUNEN);
        String description = "Dez anos atrás, depois do \"Portal\" que conecta o mundo real com um mundo de montros se abriu, algumas pessoas comuns receberam o poder de caçar os monstros do portal. Eles são conhecidos como caçadores. Porém, nem todos os caçadores são fortes. Meu nome é Sung Jin-Woo, um caçador de rank E. Eu sou alguém que tem que arriscar a própria vida nas dungeons mais fracas, \"O mais fraco do mundo\". Sem ter nenhuma habilidade à disposição, eu mal consigo dinheiro nas dungeons de baixo nível... Ao menos até eu encontrar uma dungeon escondida com a maior dificuldade dentro do Rank D! No fim, enquanto aceitava minha morte, eu ganhei um novo poder!";
        Status status = PUBLISHING;
        double score = 9.37;

        // when
        WebToon underTestWebToon = WebToonBuilder.builder()
                .id(id)
                .title(title)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThat(underTestWebToon.getId()).isEqualTo(id);
        assertThat(underTestWebToon.getTitle()).isEqualTo(title);
        assertThat(underTestWebToon.getAuthors()).containsExactlyElementsOf(authors);
        assertThat(underTestWebToon.getGenres()).containsExactlyElementsOf(genres);
        assertThat(underTestWebToon.getDescription()).isEqualTo(description);
        assertThat(underTestWebToon.getStatus()).isEqualTo(status);
        assertThat(underTestWebToon.getScore()).isEqualTo(score);
        assertThat(underTestWebToon.getAlternativeNames()).isEmpty();
    }

    @ValueSource(strings = " ")
    @NullAndEmptySource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateWebToonBecauseTitleIsNullOrEmptyOrBlank(String title) {
        // given
        Identifier id = new Identifier(1L);
        List<Author> authors = List.of(new Author("Jang Sung-Lak"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, SHOUNEN);
        String description = "Dez anos atrás, depois do \"Portal\" que conecta o mundo real com um mundo de montros se abriu, algumas pessoas comuns receberam o poder de caçar os monstros do portal. Eles são conhecidos como caçadores. Porém, nem todos os caçadores são fortes. Meu nome é Sung Jin-Woo, um caçador de rank E. Eu sou alguém que tem que arriscar a própria vida nas dungeons mais fracas, \"O mais fraco do mundo\". Sem ter nenhuma habilidade à disposição, eu mal consigo dinheiro nas dungeons de baixo nível... Ao menos até eu encontrar uma dungeon escondida com a maior dificuldade dentro do Rank D! No fim, enquanto aceitava minha morte, eu ganhei um novo poder!";
        Status status = PUBLISHING;
        double score = 9.37;

        // when
        ThrowableAssert.ThrowingCallable underTestWebToon = () -> WebToonBuilder.builder()
                .id(id)
                .title(title)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestWebToon)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(WebToon.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateWebToonBecauseAuthorsIsNullOrHasLessThanOne(List<Author> authors) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Solo Leveling";
        List<Genre> genres = List.of(ACTION, ADVENTURE, SHOUNEN);
        String description = "Dez anos atrás, depois do \"Portal\" que conecta o mundo real com um mundo de montros se abriu, algumas pessoas comuns receberam o poder de caçar os monstros do portal. Eles são conhecidos como caçadores. Porém, nem todos os caçadores são fortes. Meu nome é Sung Jin-Woo, um caçador de rank E. Eu sou alguém que tem que arriscar a própria vida nas dungeons mais fracas, \"O mais fraco do mundo\". Sem ter nenhuma habilidade à disposição, eu mal consigo dinheiro nas dungeons de baixo nível... Ao menos até eu encontrar uma dungeon escondida com a maior dificuldade dentro do Rank D! No fim, enquanto aceitava minha morte, eu ganhei um novo poder!";
        Status status = PUBLISHING;
        double score = 9.37;

        // when
        ThrowableAssert.ThrowingCallable underTestWebToon = () -> WebToonBuilder.builder()
                .id(id)
                .title(title)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestWebToon)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(WebToon.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateWebToonBecauseGenresIsNullOrHasLessThanOne(List<Genre> genres) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Solo Leveling";
        List<Author> authors = List.of(new Author("Jang Sung-Lak"));
        String description = "Dez anos atrás, depois do \"Portal\" que conecta o mundo real com um mundo de montros se abriu, algumas pessoas comuns receberam o poder de caçar os monstros do portal. Eles são conhecidos como caçadores. Porém, nem todos os caçadores são fortes. Meu nome é Sung Jin-Woo, um caçador de rank E. Eu sou alguém que tem que arriscar a própria vida nas dungeons mais fracas, \"O mais fraco do mundo\". Sem ter nenhuma habilidade à disposição, eu mal consigo dinheiro nas dungeons de baixo nível... Ao menos até eu encontrar uma dungeon escondida com a maior dificuldade dentro do Rank D! No fim, enquanto aceitava minha morte, eu ganhei um novo poder!";
        Status status = PUBLISHING;
        double score = 9.37;

        // when
        ThrowableAssert.ThrowingCallable underTestWebToon = () -> WebToonBuilder.builder()
                .id(id)
                .title(title)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestWebToon)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(WebToon.class.getSimpleName());
    }

    @ValueSource(strings = " ")
    @NullAndEmptySource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateWebToonBecauseDescriptionIsNullOrEmptyOrBlank(String description) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Solo Leveling";
        List<Author> authors = List.of(new Author("Jang Sung-Lak"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, SHOUNEN);
        Status status = PUBLISHING;
        double score = 9.37;

        // when
        ThrowableAssert.ThrowingCallable underTestWebToon = () -> WebToonBuilder.builder()
                .id(id)
                .title(title)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        assertThatThrownBy(underTestWebToon)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(WebToon.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateWebToonBecauseStatusInNull(Status status) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Solo Leveling";
        List<Author> authors = List.of(new Author("Jang Sung-Lak"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, SHOUNEN);
        String description = "Dez anos atrás, depois do \"Portal\" que conecta o mundo real com um mundo de montros se abriu, algumas pessoas comuns receberam o poder de caçar os monstros do portal. Eles são conhecidos como caçadores. Porém, nem todos os caçadores são fortes. Meu nome é Sung Jin-Woo, um caçador de rank E. Eu sou alguém que tem que arriscar a própria vida nas dungeons mais fracas, \"O mais fraco do mundo\". Sem ter nenhuma habilidade à disposição, eu mal consigo dinheiro nas dungeons de baixo nível... Ao menos até eu encontrar uma dungeon escondida com a maior dificuldade dentro do Rank D! No fim, enquanto aceitava minha morte, eu ganhei um novo poder!";
        double score = 9.37;

        // when
        ThrowableAssert.ThrowingCallable underTestWebToon = () -> WebToonBuilder.builder()
                .id(id)
                .title(title)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestWebToon)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(WebToon.class.getSimpleName());
    }

    @ArgumentsSource(ScoreArgumentsProvider.class)
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateWebToonBecauseScoreHasMoreThan2IntegerAndFractionOrIsLessThan0orIsGraderThan10(Double score) {
        // given
        Identifier id = new Identifier(1L);
        String title = "Solo Leveling";
        List<Author> authors = List.of(new Author("Jang Sung-Lak"));
        List<Genre> genres = List.of(ACTION, ADVENTURE, SHOUNEN);
        String description = "Dez anos atrás, depois do \"Portal\" que conecta o mundo real com um mundo de montros se abriu, algumas pessoas comuns receberam o poder de caçar os monstros do portal. Eles são conhecidos como caçadores. Porém, nem todos os caçadores são fortes. Meu nome é Sung Jin-Woo, um caçador de rank E. Eu sou alguém que tem que arriscar a própria vida nas dungeons mais fracas, \"O mais fraco do mundo\". Sem ter nenhuma habilidade à disposição, eu mal consigo dinheiro nas dungeons de baixo nível... Ao menos até eu encontrar uma dungeon escondida com a maior dificuldade dentro do Rank D! No fim, enquanto aceitava minha morte, eu ganhei um novo poder!";
        Status status = PUBLISHING;

        // when
        ThrowableAssert.ThrowingCallable underTestWebToon = () -> WebToonBuilder.builder()
                .id(id)
                .title(title)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        assertThatThrownBy(underTestWebToon)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(WebToon.class.getSimpleName());
    }

}