package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.ports.repository.ManhwaRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllUseCaseTest {

    private FindAllUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllUseCase(new ManhwaRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllUseCase() {
        // given
        PageInfo pageInfo = PageInfo.create(0, 10);
        FindAllUseCase.InputValues input = new FindAllUseCase.InputValues(pageInfo);

        // when
        FindAllUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.manhwas()).hasSize(pageInfo.pageSize());
        assertThat(output.manhwas())
                .map(Manhwa::getId)
                .containsExactlyElementsOf(Identifier.generateIDSequenceFrom(pageInfo));
    }
}