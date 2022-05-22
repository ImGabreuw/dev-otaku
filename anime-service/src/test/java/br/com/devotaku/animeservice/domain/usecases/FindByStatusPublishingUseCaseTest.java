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

import static br.com.devotaku.animeservice.domain.entities.enums.Status.PUBLISHING;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindByStatusPublishingUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindByStatusPublishingUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByStatusPublishingUseCase(animeRepository);
    }

    @DisplayName("Should execute FindByStatusPublishingUseCase")
    @Test
    void shouldExecuteFindByStatusPublishingUseCase() {
        var page = PageInfo.createDefault();

        var input = new FindByStatusPublishingUseCase.InputValues(page);

        var output = underTest.execute(input);

        assertThat(output.animeList())
                .map(Anime::getStatus)
                .containsOnly(PUBLISHING);
    }

}