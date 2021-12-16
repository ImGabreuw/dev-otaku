package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.comicdomain.gateway.repository.MangaRepositoryMock;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FindByTitleOrAlternativesNameUseCaseTest {

    private FindByTitleOrAlternativesNameUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindByTitleOrAlternativesNameUseCase(new MangaRepositoryMock());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "One Piece",
            "ONE PIECE"
    })
    void shouldExecuteUseCase(String mangaName) {
        // given
        FindByTitleOrAlternativesNameUseCase.InputValues input = new FindByTitleOrAlternativesNameUseCase.InputValues(mangaName);

        // when
        FindByTitleOrAlternativesNameUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.manga()).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = "One Piece One Piece")
    void shouldThrowEntityNotFoundExceptionWhenExecuteUseCaseBecauseMangaNameDoesNotExist(String mangaName) {
        // given
        FindByTitleOrAlternativesNameUseCase.InputValues input = new FindByTitleOrAlternativesNameUseCase.InputValues(mangaName);

        //  when
        ThrowableAssert.ThrowingCallable output = () -> underTestUseCase.execute(input);

        // then
        assertThatThrownBy(output)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(String.format(
                        "Não foi possível encontrar um [manga] com [title=%s e/ou alternativeNames=%s]",
                        mangaName, mangaName
                ));
    }
}