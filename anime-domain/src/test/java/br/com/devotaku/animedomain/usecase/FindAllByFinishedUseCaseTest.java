package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.ports.repository.AnimeRepositoryMock;
import br.com.devotaku.shared.pagination.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllByFinishedUseCaseTest {

    private FindAllByFinishedUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindAllByFinishedUseCase(new AnimeRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllByFinishedUSeCase() {
        // given
        var pageInfo = PageInfo.create(0, 10);
        var input = new FindAllByFinishedUseCase.InputValues(pageInfo);

        // when
        var output = underTest.execute(input);

        // then
        assertThat(output.animes()).hasSize(pageInfo.pageSize());
        assertThat(output.animes()).allMatch(Anime::isFinished);
    }
}