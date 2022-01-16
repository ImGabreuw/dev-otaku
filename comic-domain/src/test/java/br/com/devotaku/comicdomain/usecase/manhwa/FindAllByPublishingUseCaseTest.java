package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.ports.repository.ManhwaRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllByPublishingUseCaseTest {

    private FindAllByPublishingUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllByPublishingUseCase(new ManhwaRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllByPublishingUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FindAllByPublishingUseCase.InputValues input = new FindAllByPublishingUseCase.InputValues(pageInfo);

        // when
        FindAllByPublishingUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.manhwas()).hasSize(pageInfo.pageSize());
        assertThat(output.manhwas()).allMatch(Manhwa::isPublishing);
    }
}