package br.com.devotaku.comicdomain.usecase.webtoon;

import br.com.devotaku.comicdomain.entity.WebToon;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.ports.repository.WebToonRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllByFinishedUseCaseTest {

    private FindAllByFinishedUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllByFinishedUseCase(new WebToonRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllByFinishedUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FindAllByFinishedUseCase.InputValues input = new FindAllByFinishedUseCase.InputValues(pageInfo);

        // when
        FindAllByFinishedUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.webToons()).hasSize(pageInfo.pageSize());
        assertThat(output.webToons()).allMatch(WebToon::isFinished);
    }

}