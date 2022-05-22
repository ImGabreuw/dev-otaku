package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.devotaku.animeservice.domain.entities.enums.Status.FINISHED;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindByStatusFinishedUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindByStatusFinishedUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByStatusFinishedUseCase(animeRepository);
    }

    @DisplayName("Should execute FindByStatusFinishedUseCase")
    @Test
    void shouldExecuteFindByStatusFinishedUseCase() {
        var page = PageInfo.createDefault();

        var input = new FindByStatusFinishedUseCase.InputValues(page);

        var output = underTest.execute(input);

        assertThat(output.animeList()).hasSize(page.pageSize());
        assertThat(output.animeList())
                .map(Anime::getStatus)
                .containsOnly(FINISHED);
    }

}