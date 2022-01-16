package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.ports.repository.ManhwaRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllByFinishedUseCaseTest {

    private FindAllByFinishedUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllByFinishedUseCase(new ManhwaRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllByFinishedUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FindAllByFinishedUseCase.InputValues input = new FindAllByFinishedUseCase.InputValues(pageInfo);

        // then
        FindAllByFinishedUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.manhwas()).hasSize(pageInfo.pageSize());
        assertThat(output.manhwas()).allMatch(Manhwa::isFinished);
    }
}