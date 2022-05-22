package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.value.objects.Score;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FetchTopUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FetchTopUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FetchTopUseCase(animeRepository);
    }

    @DisplayName("Should execute FetchTopUseCase")
    @Test
    void shouldExecuteFetchTopUseCase() {
        var page = PageInfo.createDefault();

        var input = new FetchTopUseCase.InputValues(page);

        var output = underTest.execute(input);

        System.out.println(output);

        assertThat(output.animeList())
                .map(Anime::getScore)
                .map(Score::value)
                .isSortedAccordingTo(Comparator.reverseOrder());
    }

}