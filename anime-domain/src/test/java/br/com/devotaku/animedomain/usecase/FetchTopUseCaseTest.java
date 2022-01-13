package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.ports.repository.AnimeRepositoryMock;
import br.com.devotaku.shared.pagination.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class FetchTopUseCaseTest {

    private FetchTopUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FetchTopUseCase(new AnimeRepositoryMock());
    }

    @Test
    void shouldExecuteFetchTopUseCase() {
        // given
        var pageInfo = PageInfo.create(0, 10);
        var input = new FetchTopUseCase.InputValues(pageInfo);

        // when
        var output = underTest.execute(input);

        // then
        assertThat(output.animes()).hasSize(pageInfo.pageSize());
        assertThat(output.animes()).isSortedAccordingTo(Comparator.reverseOrder());
    }
}