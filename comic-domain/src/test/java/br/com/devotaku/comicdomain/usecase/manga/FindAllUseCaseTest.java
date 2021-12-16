package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.comicdomain.entity.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.gateway.repository.MangaRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllUseCaseTest {

    private FindAllUseCase underTestUseCase;

    @BeforeEach
    void setUp() {
        underTestUseCase = new FindAllUseCase(new MangaRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllUseCase() {
        // given
        int pageNumber = 0;
        int pageSize = 20;

        PageInfo pageInfo = PageInfo.create(pageNumber, pageSize);
        FindAllUseCase.InputValues input = new FindAllUseCase.InputValues(pageInfo);

        // when
        FindAllUseCase.OutputValues output = underTestUseCase.execute(input);

        // then
        assertThat(output.mangas()).hasSize(pageSize);
        assertThat(output.mangas())
                .map(Manga::getId)
                .containsExactlyElementsOf(Identifier.generateIDSequenceFrom(pageInfo));
    }

}
