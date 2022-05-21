package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.value.objects.AlternativeName;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindByTitleOrAlternativeNamesUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindByTitleOrAlternativeNamesUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByTitleOrAlternativeNamesUseCase(animeRepository);
    }

    @DisplayName("Should execute FindByTitleOrAlternativeNamesUseCase passing the title of anime")
    @Test
    void shouldExecuteFindByTitleOrAlternativeNamesUseCasePassingTheTitleOfAnime() {
        var pageInfo = PageInfo.createDefault();
        var animeFromDb = animeRepository
                .findById(2L)
                .orElse(null);

        if (animeFromDb == null) {
            fail("Anime must not be null.");
        }

        var input = new FindByTitleOrAlternativeNamesUseCase.InputValues(
                animeFromDb.getTitle().value(),
                pageInfo
        );

        var output = underTest.execute(input);

        assertThat(output.animeList()).contains(animeFromDb);
    }

    @DisplayName("Should execute FindByTitleOrAlternativeNamesUseCase passing an alternative name of anime")
    @Test
    void shouldExecuteFindByTitleOrAlternativeNamesUseCasePassingAnAlternativeNameOfAnime() {
        var pageInfo = PageInfo.createDefault();
        var animeFromDb = animeRepository
                .findById(2L)
                .orElse(null);

        if (animeFromDb == null) {
            fail("Anime must not be null.");
        }

        animeFromDb
                .getAlternativeNames()
                .stream()
                .map(AlternativeName::value)
                .forEach(animeName -> {
                    var input = new FindByTitleOrAlternativeNamesUseCase.InputValues(
                            animeName,
                            pageInfo
                    );

                    var output = underTest.execute(input);

                    assertThat(output.animeList()).contains(animeFromDb);
                });
    }

    @DisplayName("Should throw AnimeNotFoundException because do not have any anime named")
    @Test
    void shouldThrowAnimeNotFoundExceptionBecauseDoNotHaveAnyAnimeNamed() {
        var pageInfo = PageInfo.createDefault();
        var animeFromDb = animeRepository
                .findById(2L)
                .orElse(null);

        if (animeFromDb == null) {
            fail("Anime must not be null.");
        }

        var animeName = StringUtils.reverse(animeFromDb.getTitle().value());

        var input = new FindByTitleOrAlternativeNamesUseCase.InputValues(
                animeName,
                pageInfo
        );

        assertThatThrownBy(() -> underTest.execute(input))
                .isInstanceOf(AnimeNotFoundException.class)
                .hasMessage("There is no anime named (%s).".formatted(animeName));
    }

}