package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.ports.repository.MangaRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class FetchTopUseCaseTest {

    private FetchTopUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FetchTopUseCase(new MangaRepositoryMock());
    }

    @Test
    void shouldExecuteFetchTopUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FetchTopUseCase.InputValues input = new FetchTopUseCase.InputValues(pageInfo);

        // when
        FetchTopUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.mangas()).hasSize(pageInfo.pageSize());
        assertThat(output.mangas()).isSortedAccordingTo(Comparator.reverseOrder());
    }
}