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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindByGenresUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindByGenresUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByGenresUseCase(animeRepository);
    }

    @DisplayName("Should execute FindByGenresUseCase")
    @Test
    void shouldExecuteFindByGenresUseCase() {
        var page = PageInfo.createDefault();
        var animeFromDb = animeRepository
                .findById(1L)
                .orElseThrow();
        var genres = animeFromDb.getGenres();

        var input = new FindByGenresUseCase.InputValues(genres, page);

        var output = underTest.execute(input);

        assertThat(output.animeList())
                .map(Anime::getGenres)
                .contains(genres);
    }

}