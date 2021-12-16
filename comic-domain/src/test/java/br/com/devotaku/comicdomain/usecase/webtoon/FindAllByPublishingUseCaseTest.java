package br.com.devotaku.comicdomain.usecase.webtoon;

import br.com.devotaku.comicdomain.entity.WebToon;
import br.com.devotaku.comicdomain.entity.pagination.PageInfo;
import br.com.devotaku.comicdomain.gateway.repository.WebToonRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllByPublishingUseCaseTest {

    private FindAllByPublishingUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllByPublishingUseCase(new WebToonRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllByPublishingUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FindAllByPublishingUseCase.InputValues input = new FindAllByPublishingUseCase.InputValues(pageInfo);

        // when
        FindAllByPublishingUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.webToons()).hasSize(pageInfo.pageSize());
        assertThat(output.webToons()).allMatch(WebToon::isPublishing);
    }

}