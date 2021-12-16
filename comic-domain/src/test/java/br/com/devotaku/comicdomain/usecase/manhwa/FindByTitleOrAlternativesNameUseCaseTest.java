package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.gateway.repository.ManhwaRepositoryMock;
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
        underTestUseCase = new FindByTitleOrAlternativesNameUseCase(new ManhwaRepositoryMock());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Tales Of Demons And Gods",
            "tdg"
    })
    void shouldExecuteFindByTitleOrAlternativesNameUseCase(String manhwaName) {
        // given
        FindByTitleOrAlternativesNameUseCase.InputValues input = new FindByTitleOrAlternativesNameUseCase.InputValues(manhwaName);

        // when
        FindByTitleOrAlternativesNameUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.manhwa()).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = "Tales Of Demons And Gods tdg")
    void shouldThrowEntityNotFoundExceptionWhenExecuteUseCaseBecauseDoesNotExist(String manhwaName) {
        // given
        FindByTitleOrAlternativesNameUseCase.InputValues input = new FindByTitleOrAlternativesNameUseCase.InputValues(manhwaName);

        // when
        ThrowableAssert.ThrowingCallable output = () -> underTestUseCase.execute(input);

        // then
        assertThatThrownBy(output)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(String.format(
                        "Não foi possível encontrar um [manhwa] com [title=%s e/ou alternativeNames=%s]",
                        manhwaName, manhwaName
                ));
    }

}