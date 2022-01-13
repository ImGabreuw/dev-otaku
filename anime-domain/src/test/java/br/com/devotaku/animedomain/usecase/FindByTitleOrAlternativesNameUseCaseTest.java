package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.ports.repository.AnimeRepositoryMock;
import br.com.devotaku.animedomain.usecase.execption.EntityNotFoundException;
import br.com.devotaku.animedomain.usecase.execption.IllegalInputException;
import br.com.devotaku.animedomain.utils.NullEmptyAndBlankSource;
import br.com.devotaku.animedomain.utils.arguments.provider.AnimeNameArguments;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FindByTitleOrAlternativesNameUseCaseTest {

    private FindByTitleOrAlternativesNameUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByTitleOrAlternativesNameUseCase(new AnimeRepositoryMock());
    }

    @ParameterizedTest
    @AnimeNameArguments
    void shouldExecuteFindByTitleOrAlternativesName(String animeName) {
        // given
        var input = new FindByTitleOrAlternativesNameUseCase.InputValues(animeName);

        // when
        var output = underTest.execute(input);

        // then
        assertThat(output.anime()).isNotNull();
        assertThat(output.anime().hasTitleOrAlternativeNamesEqualsTo(animeName)).isTrue();
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowEntityNotFoundExceptionWhenExecuteFindByTitleOrAlternativesNameBecauseTitleOrAlternativesNameIsInvalid(String animeName) {
        // given
        var input = new FindByTitleOrAlternativesNameUseCase.InputValues(animeName);

        // when
        ThrowableAssert.ThrowingCallable output = () -> underTest.execute(input);

        // then
        assertThatThrownBy(output)
                .isInstanceOf(IllegalInputException.class)
                .hasMessage(String.format(
                        "Valor de entrada inválido para [FindByTitleOrAlternativesNameUseCase.InputValues] com [animeName=%s]",
                        animeName
                ));
    }

    @Test
    void shouldThrowEntityNotFoundExceptionWhenExecuteFindByTitleOrAlternativesNameBecauseTitleOrAlternativesNameDoesNotExist() {
        // given
        var animeName = "Jujutsu Kaisennnnnn";
        FindByTitleOrAlternativesNameUseCase.InputValues input = new FindByTitleOrAlternativesNameUseCase.InputValues(animeName);

        // when
        ThrowableAssert.ThrowingCallable output = () -> underTest.execute(input);

        // then
        assertThatThrownBy(output)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(String.format(
                        "Não foi possível encontrar um [anime] com [title=%s e/ou alternativeNames=%s]",
                        animeName,
                        animeName
                ));
    }
}