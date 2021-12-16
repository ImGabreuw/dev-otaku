package br.com.devotaku.comicdomain.usecase.webtoon;

import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.gateway.repository.WebToonRepositoryMock;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FindByIdUseCaseTest {

    private FindByIdUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindByIdUseCase(new WebToonRepositoryMock());
    }

    @Test
    void shouldExecuteFindByIdUseCase() {
        // given
        Identifier id = new Identifier(1L);
        FindByIdUseCase.InputValues input = new FindByIdUseCase.InputValues(id);

        // when
        FindByIdUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.webToon()).isNotNull();
        assertThat(output.webToon().getId()).isEqualTo(id);
    }

    @Test
    void shouldThrowEntityNotFoundExceptionWhenExecuteUseCaseBecauseIdIsNot1() {
        // given
        Identifier id = new Identifier(2L);
        FindByIdUseCase.InputValues input = new FindByIdUseCase.InputValues(id);

        // when
        ThrowableAssert.ThrowingCallable output = () -> underTestUseCase.execute(input);

        // then
        assertThatThrownBy(output)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Não foi possível encontrar um [webtoon] com [id=2]");
    }

}