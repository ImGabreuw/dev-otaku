package br.com.devotaku.comicdomain.usecase.webtoon;

import br.com.devotaku.comicdomain.gateway.repository.WebToonRepositoryMock;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FindByTitleOrAlternativesNameUseCaseTest {

    private FindByTitleOrAlternativesNameUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindByTitleOrAlternativesNameUseCase(new WebToonRepositoryMock());
    }

    @Test
    void shouldExecuteFindByTitleOrAlternativesNameUseCase() {
        // given
        String webToonName = "Solo Leveling";
        FindByTitleOrAlternativesNameUseCase.InputValues input = new FindByTitleOrAlternativesNameUseCase.InputValues(webToonName);

        // when
        FindByTitleOrAlternativesNameUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.webToon()).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = "Solo Leveling Solo Leveling")
    void shouldThrowEntityNotFoundExceptionWhenExecuteUseCaseBecauseWebToonNameDoesNotExist(String webToonName) {
        // given
        FindByTitleOrAlternativesNameUseCase.InputValues input = new FindByTitleOrAlternativesNameUseCase.InputValues(webToonName);

        // when
        ThrowableAssert.ThrowingCallable output = () -> underTestUseCase.execute(input);

        // then
        assertThatThrownBy(output)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(String.format(
                        "Não foi possível encontrar um [webtoon] com [title=%s e/ou alternativeNames=%s]",
                        webToonName, webToonName
                ));
    }

}