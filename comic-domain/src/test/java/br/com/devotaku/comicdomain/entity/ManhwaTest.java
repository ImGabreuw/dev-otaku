package br.com.devotaku.comicdomain.entity;

import br.com.devotaku.comicdomain.entity.builder.ManhwaBuilder;
import br.com.devotaku.comicdomain.entity.value.object.AlternativeName;
import br.com.devotaku.comicdomain.entity.value.object.Author;
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

class ManhwaTest {

    @Test
    void shouldCreateManhwa() {
        // given
        String title = "Tales Of Demons And Gods";
        Author[] authors = new Author[]{new Author("Mad Snail")};
        Genre[] genres = {MARTIAL_ARTS, ADVENTURE, SHOUNEN, SUPERNATURAL};
        String description = "Nie Li, o mais poderoso Espiritualista Demoníaco e estando no topo do mundo marcial, perde sua vida durante a batalha com o Imperador Sábio e as seis bestas de nível divino, e sua alma volta ao passado para quando ele tinha 13 anos. Embora ele seja o mais fraco em sua classe, com o talento mais baixo no reino da alma Vermelho – o mais fraco dos reinos – com a ajuda de seu vasto conhecimento acumulado na sua vida passada, cresce mais rápido do que todos.Agora, ele irá tentar proteger a cidade que no futuro será invadida pelas bestas e que acabou sendo destruída, assim como sua amada, seus amigos e sua família que morreram pelo ataque das mesmas, e destruir a família Sagrada que abandonaram seus deveres e traíram a cidade em sua vida passada.";
        Status status = PUBLISHING;
        double score = 9.18;
        AlternativeName alternativeName = new AlternativeName("tdg");

        // when
        Manhwa underTestManhwa = ManhwaBuilder.builder()
                .title(title)
                .alternativeNames(alternativeName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThat(underTestManhwa.getTitle()).isEqualTo(title);
        assertThat(underTestManhwa.getAuthors()).containsExactly(authors);
        assertThat(underTestManhwa.getGenres()).containsExactly(genres);
        assertThat(underTestManhwa.getDescription()).isEqualTo(description);
        assertThat(underTestManhwa.getStatus()).isEqualTo(status);
        assertThat(underTestManhwa.getScore()).isEqualTo(score);
        assertThat(underTestManhwa.getAlternativeNames()).containsExactly(alternativeName);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    void shouldThrowValidationExceptionWhenCreateManhwaBecauseTitleIsNullOrEmptyOrBlank(String title) {
        // given
        Author author = new Author("Mad Snail");
        Genre[] genres = {MARTIAL_ARTS, ADVENTURE, SHOUNEN, SUPERNATURAL};
        String description = "Nie Li, o mais poderoso Espiritualista Demoníaco e estando no topo do mundo marcial, perde sua vida durante a batalha com o Imperador Sábio e as seis bestas de nível divino, e sua alma volta ao passado para quando ele tinha 13 anos. Embora ele seja o mais fraco em sua classe, com o talento mais baixo no reino da alma Vermelho – o mais fraco dos reinos – com a ajuda de seu vasto conhecimento acumulado na sua vida passada, cresce mais rápido do que todos.Agora, ele irá tentar proteger a cidade que no futuro será invadida pelas bestas e que acabou sendo destruída, assim como sua amada, seus amigos e sua família que morreram pelo ataque das mesmas, e destruir a família Sagrada que abandonaram seus deveres e traíram a cidade em sua vida passada.";
        Status status = PUBLISHING;
        double score = 9.18;
        AlternativeName alternativeName = new AlternativeName("tdg");

        // when
        ThrowableAssert.ThrowingCallable underTestManhwa = () -> ManhwaBuilder.builder()
                .title(title)
                .alternativeNames(alternativeName)
                .authors(author)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManhwa)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manhwa.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateManhwaBecauseAuthorsIsNullOrHasLessThanOne(List<Author> authors) {
        // given
        String title = "Tales Of Demons And Gods";
        Genre[] genres = {MARTIAL_ARTS, ADVENTURE, SHOUNEN, SUPERNATURAL};
        String description = "Nie Li, o mais poderoso Espiritualista Demoníaco e estando no topo do mundo marcial, perde sua vida durante a batalha com o Imperador Sábio e as seis bestas de nível divino, e sua alma volta ao passado para quando ele tinha 13 anos. Embora ele seja o mais fraco em sua classe, com o talento mais baixo no reino da alma Vermelho – o mais fraco dos reinos – com a ajuda de seu vasto conhecimento acumulado na sua vida passada, cresce mais rápido do que todos.Agora, ele irá tentar proteger a cidade que no futuro será invadida pelas bestas e que acabou sendo destruída, assim como sua amada, seus amigos e sua família que morreram pelo ataque das mesmas, e destruir a família Sagrada que abandonaram seus deveres e traíram a cidade em sua vida passada.";
        Status status = PUBLISHING;
        double score = 9.18;
        AlternativeName alternativeName = new AlternativeName("tdg");

        // when
        ThrowableAssert.ThrowingCallable underTestManhwa = () -> ManhwaBuilder.builder()
                .title(title)
                .alternativeNames(alternativeName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManhwa)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manhwa.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateManhwaBecauseGenresIsNullOrHasLessThanOne(List<Genre> genres) {
        // given
        String title = "Tales Of Demons And Gods";
        Author[] authors = new Author[]{new Author("Mad Snail")};
        String description = "Nie Li, o mais poderoso Espiritualista Demoníaco e estando no topo do mundo marcial, perde sua vida durante a batalha com o Imperador Sábio e as seis bestas de nível divino, e sua alma volta ao passado para quando ele tinha 13 anos. Embora ele seja o mais fraco em sua classe, com o talento mais baixo no reino da alma Vermelho – o mais fraco dos reinos – com a ajuda de seu vasto conhecimento acumulado na sua vida passada, cresce mais rápido do que todos.Agora, ele irá tentar proteger a cidade que no futuro será invadida pelas bestas e que acabou sendo destruída, assim como sua amada, seus amigos e sua família que morreram pelo ataque das mesmas, e destruir a família Sagrada que abandonaram seus deveres e traíram a cidade em sua vida passada.";
        Status status = PUBLISHING;
        double score = 9.18;
        AlternativeName alternativeName = new AlternativeName("tdg");

        // when
        ThrowableAssert.ThrowingCallable underTestManhwa = () -> ManhwaBuilder.builder()
                .title(title)
                .alternativeNames(alternativeName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManhwa)
                .isInstanceOf(ValidationException.class);
    }

    @ValueSource(strings = " ")
    @NullAndEmptySource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateManhwaBecauseDescriptionIsNullOrEmptyOrBlank(String description) {
        // given
        String title = "Tales Of Demons And Gods";
        Author[] authors = new Author[]{new Author("Mad Snail")};
        Genre[] genres = {MARTIAL_ARTS, ADVENTURE, SHOUNEN, SUPERNATURAL};
        Status status = PUBLISHING;
        double score = 9.18;
        AlternativeName alternativeName = new AlternativeName("tdg");

        // when
        ThrowableAssert.ThrowingCallable underTestManhwa = () -> ManhwaBuilder.builder()
                .title(title)
                .alternativeNames(alternativeName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManhwa)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manhwa.class.getSimpleName());
    }

    @NullSource
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateManhwaBecauseStatusInNull(Status status) {
        // given
        String title = "Tales Of Demons And Gods";
        Author[] authors = new Author[]{new Author("Mad Snail")};
        Genre[] genres = {MARTIAL_ARTS, ADVENTURE, SHOUNEN, SUPERNATURAL};
        String description = "Nie Li, o mais poderoso Espiritualista Demoníaco e estando no topo do mundo marcial, perde sua vida durante a batalha com o Imperador Sábio e as seis bestas de nível divino, e sua alma volta ao passado para quando ele tinha 13 anos. Embora ele seja o mais fraco em sua classe, com o talento mais baixo no reino da alma Vermelho – o mais fraco dos reinos – com a ajuda de seu vasto conhecimento acumulado na sua vida passada, cresce mais rápido do que todos.Agora, ele irá tentar proteger a cidade que no futuro será invadida pelas bestas e que acabou sendo destruída, assim como sua amada, seus amigos e sua família que morreram pelo ataque das mesmas, e destruir a família Sagrada que abandonaram seus deveres e traíram a cidade em sua vida passada.";
        double score = 9.18;
        AlternativeName alternativeName = new AlternativeName("tdg");

        // when
        ThrowableAssert.ThrowingCallable underTestManhwa = () -> ManhwaBuilder.builder()
                .title(title)
                .alternativeNames(alternativeName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManhwa)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manhwa.class.getSimpleName());
    }

    @ArgumentsSource(ScoreArgumentsProvider.class)
    @ParameterizedTest
    void shouldThrowValidationExceptionWhenCreateManhwaBecauseScoreHasMoreThan2IntegerAndFractionOrIsLessThan0orIsGraderThan10(Double score) {
        // given
        String title = "Tales Of Demons And Gods";
        Author[] authors = new Author[]{new Author("Mad Snail")};
        Genre[] genres = {MARTIAL_ARTS, ADVENTURE, SHOUNEN, SUPERNATURAL};
        String description = "Nie Li, o mais poderoso Espiritualista Demoníaco e estando no topo do mundo marcial, perde sua vida durante a batalha com o Imperador Sábio e as seis bestas de nível divino, e sua alma volta ao passado para quando ele tinha 13 anos. Embora ele seja o mais fraco em sua classe, com o talento mais baixo no reino da alma Vermelho – o mais fraco dos reinos – com a ajuda de seu vasto conhecimento acumulado na sua vida passada, cresce mais rápido do que todos.Agora, ele irá tentar proteger a cidade que no futuro será invadida pelas bestas e que acabou sendo destruída, assim como sua amada, seus amigos e sua família que morreram pelo ataque das mesmas, e destruir a família Sagrada que abandonaram seus deveres e traíram a cidade em sua vida passada.";
        Status status = PUBLISHING;
        AlternativeName alternativeName = new AlternativeName("tdg");

        // when
        ThrowableAssert.ThrowingCallable underTestManhwa = () -> ManhwaBuilder.builder()
                .title(title)
                .alternativeNames(alternativeName)
                .authors(authors)
                .genres(genres)
                .description(description)
                .status(status)
                .score(score)
                .build();

        // then
        assertThatThrownBy(underTestManhwa)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(Manhwa.class.getSimpleName());
    }

}