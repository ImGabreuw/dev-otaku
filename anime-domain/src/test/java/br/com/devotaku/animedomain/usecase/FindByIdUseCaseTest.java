package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.entity.value.object.Identifier;
import br.com.devotaku.animedomain.ports.repository.AnimeRepositoryMock;
import br.com.devotaku.animedomain.usecase.execption.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FindByIdUseCaseTest {

    private FindByIdUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByIdUseCase(new AnimeRepositoryMock());
    }

    @Test
    void shouldExecuteFindAnimeByIdUseCase() {
        // given
        Long id = 1L;
        FindByIdUseCase.InputValues input = new FindByIdUseCase.InputValues(id);

        // when
        FindByIdUseCase.OutputValues output = underTest.execute(input);

        // then
        assertThat(output.anime()).isNotNull();
        assertThat(output.anime().getId()).isEqualTo(new Identifier(id));
    }

    @Test
    void shouldThrowEntityNotFoundWhenExecuteFindByIdUseCaseBecauseIdIsInvalid() {
        // given
        Long id = 10L;
        FindByIdUseCase.InputValues input = new FindByIdUseCase.InputValues(id);

        // when

        // then
        ThrowableAssert.ThrowingCallable output = () -> underTest.execute(input);
        assertThatThrownBy(output)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(String.format(
                        "Não foi possível encontrar um [anime] com [id=%s]",
                        id
                ));
    }

}