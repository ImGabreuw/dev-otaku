package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.ports.repository.ManhwaRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class FetchTopUseCaseTest {

    private FetchTopUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FetchTopUseCase(new ManhwaRepositoryMock());
    }

    @Test
    void shouldExecuteFetchTopUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FetchTopUseCase.InputValues input = new FetchTopUseCase.InputValues(pageInfo);

        // when
        FetchTopUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.manhwas()).hasSize(pageInfo.pageSize());
        assertThat(output.manhwas()).isSortedAccordingTo(Comparator.reverseOrder());
    }
}