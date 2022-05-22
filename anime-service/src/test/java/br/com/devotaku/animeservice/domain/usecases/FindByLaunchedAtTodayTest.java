package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.builder.AnimeBuilder;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.generators.IdentifierUtils;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindByLaunchedAtTodayTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindByLaunchedAtToday underTest;

    @BeforeEach
    void setUp() {
        mockAnimeWithLaunchedAtToday().forEach(animeRepository::save);

        underTest = new FindByLaunchedAtToday(animeRepository);
    }

    @DisplayName("Should execute FindByLaunchedAtToday")
    @Test
    void shouldExecuteFindByLaunchedAtToday() {
        var page = PageInfo.createDefault();

        var input = new FindByLaunchedAtToday.InputValues(page);

        var output = underTest.execute(input);

        assertThat(output.animeList())
                .map(Anime::getLaunchedAt)
                .containsOnly(LocalDate.now());
    }

    private List<Anime> mockAnimeWithLaunchedAtToday() {
        var limit = PageInfo.createDefault().pageSize();
        var identifiers = IdentifierUtils.getInstance().generateIdentifierSequence(1, limit);

        return identifiers
                .stream()
                .map(id -> AnimeBuilder.builder()
                        .id(id)
                        .title()
                        .alternativeNames()
                        .description()
                        .score()
                        .episodes()
                        .status()
                        .launchedAt(LocalDate.now())
                        .endedAt()
                        .producers()
                        .studios()
                        .source()
                        .genres()
                        .build()
                )
                .collect(Collectors.toList());
    }

}