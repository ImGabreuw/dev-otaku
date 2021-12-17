package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.gateway.repository.MangaRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllByFinishedUseCaseTest {

    private FindAllByFinishedUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllByFinishedUseCase(new MangaRepositoryMock());
    }

    @Test
    void shouldExecuteUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FindAllByFinishedUseCase.InputValues input = new FindAllByFinishedUseCase.InputValues(pageInfo);

        // when
        FindAllByFinishedUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.mangas()).hasSize(pageInfo.pageSize());
        assertThat(output.mangas()).allMatch(Manga::isFinished);
    }

}