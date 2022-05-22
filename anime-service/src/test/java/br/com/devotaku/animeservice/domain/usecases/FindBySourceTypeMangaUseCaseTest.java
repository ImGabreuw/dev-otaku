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

import static br.com.devotaku.animeservice.domain.entities.enums.SourceType.MANGA;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindBySourceTypeMangaUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindBySourceTypeMangaUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindBySourceTypeMangaUseCase(animeRepository);
    }

    @DisplayName("Should execute FindBySourceTypeMangaUseCase")
    @Test
    void shouldExecuteFindBySourceTypeMangaUseCase() {
        var page = PageInfo.createDefault();

        var input = new FindBySourceTypeMangaUseCase.InputValues(page);

        var output = underTest.execute(input);

        assertThat(output.animeList())
                .map(Anime::getSource)
                .containsOnly(MANGA);
    }

}