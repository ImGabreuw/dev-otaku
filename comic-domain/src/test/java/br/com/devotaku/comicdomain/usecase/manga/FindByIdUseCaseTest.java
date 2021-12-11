package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.gateway.MangaRepositoryMock;
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
        underTestUseCase = new FindByIdUseCase(new MangaRepositoryMock());
    }

    @Test
    void shouldExecuteFindByIdUseCase() {
        // given
        Identifier id = new Identifier(1L);
        FindByIdUseCase.InputValues input = new FindByIdUseCase.InputValues(id);

        // when
        FindByIdUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.manga()).isNotNull();
        assertThat(output.manga().getId()).isEqualTo(id);
    }

    @Test
    void shouldThrowEntityNotFoundWhenExecuteUseCaseBecauseIdDoesNotExist() {
        // given
        Identifier id = new Identifier(2L);
        FindByIdUseCase.InputValues input = new FindByIdUseCase.InputValues(id);

        // when
        ThrowableAssert.ThrowingCallable output = () -> underTestUseCase.execute(input);

        // then
        assertThatThrownBy(output)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Não foi possível encontrar um [manga] com [id=2]");
    }

}