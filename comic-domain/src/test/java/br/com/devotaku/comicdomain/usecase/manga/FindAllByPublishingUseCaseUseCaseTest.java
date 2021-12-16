package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.comicdomain.entity.pagination.PageInfo;
import br.com.devotaku.comicdomain.gateway.repository.MangaRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllByPublishingUseCaseUseCaseTest {

    private FindAllByPublishingUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllByPublishingUseCase(new MangaRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllByPublishingUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FindAllByPublishingUseCase.InputValues input = new FindAllByPublishingUseCase.InputValues(pageInfo);

        // when
        FindAllByPublishingUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.mangas()).hasSize(pageInfo.pageSize());
        assertThat(output.mangas()).allMatch(Manga::isPublishing);
    }

}