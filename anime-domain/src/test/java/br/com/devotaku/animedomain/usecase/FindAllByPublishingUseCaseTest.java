package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.ports.repository.AnimeRepositoryMock;
import br.com.devotaku.shared.pagination.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllByPublishingUseCaseTest {

    private FindAllByPublishingUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindAllByPublishingUseCase(new AnimeRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllByPublishingUseCase() {
        // given
        var pageInfo = PageInfo.create(0, 10);
        var input = new FindAllByPublishingUseCase.InputValues(pageInfo);

        // when
        var output = underTest.execute(input);

        // then
        assertThat(output.animes()).hasSize(pageInfo.pageSize());
        assertThat(output.animes()).allMatch(Anime::isPublishing);
    }
}