package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.entity.value.object.Identifier;
import br.com.devotaku.animedomain.ports.repository.AnimeRepositoryMock;
import br.com.devotaku.shared.pagination.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllUseCaseTest {

    private FindAllUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindAllUseCase(new AnimeRepositoryMock());
    }

    @Test
    void shouldExecuteFindAllUseCase() {
        // given
        var pageInfo = PageInfo.create(0, 10);
        var input = new FindAllUseCase.InputValues(pageInfo);

        // when
        var output = underTest.execute(input);

        // then
        assertThat(output.animes()).hasSize(pageInfo.pageSize());
        assertThat(output.animes())
                .map(Anime::getId)
                .containsExactlyElementsOf(Identifier.generateIDSequenceFrom(pageInfo));
    }
}