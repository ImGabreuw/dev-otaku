package br.com.devotaku.comicdomain.usecase.webtoon;

import br.com.devotaku.comicdomain.entity.WebToon;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.gateway.repository.WebToonRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllUseCaseTest {

    private FindAllUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllUseCase(new WebToonRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FindAllUseCase.InputValues input = new FindAllUseCase.InputValues(pageInfo);

        // when
        FindAllUseCase.OutputValues output = underTestUseCase.execute(input);

        // when
        assertThat(output.webToons()).hasSize(pageInfo.pageSize());
        assertThat(output.webToons())
                .map(WebToon::getId)
                .containsExactlyElementsOf(Identifier.generateIDSequenceFrom(pageInfo));
    }

}