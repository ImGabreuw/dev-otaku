package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.value.objects.Studio;
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

import static br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException.MessageTemplate.ANIME_NOT_FOUND_BY_STUDIO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindByStudioUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindByStudioUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByStudioUseCase(animeRepository);
    }

    @DisplayName("Should execute FindByStudioUseCase")
    @Test
    void shouldExecuteFindByStudioUseCase() {
        var page = PageInfo.createDefault();

        var animeFromDb = animeRepository.findById(1L).orElseThrow();

        var studioNames = animeFromDb.getStudios().stream().map(Studio::value).toList();

        studioNames.forEach(studioName -> {
            var input = new FindByStudioUseCase.InputValues(studioName, page);

            var output = underTest.execute(input);

            assertThat(output.animeList()).containsExactly(animeFromDb);
        });
    }

    @DisplayName("Should throw AnimeNotFoundException because was not found any anime with this studio")
    @Test
    void shouldThrowAnimeNotFoundExceptionBecauseWasNotFoundAnyAnimeWithThisStudio() {
        var page = PageInfo.createDefault();

        var animeFromDb = animeRepository.findById(1L).orElseThrow();

        var studioNames = animeFromDb.getStudios().stream().map(Studio::value).toList();

        studioNames.forEach(studioName -> {
            var input = new FindByStudioUseCase.InputValues(StringUtils.reverse(studioName), page);

            assertThatThrownBy(() -> underTest.execute(input))
                    .isInstanceOf(AnimeNotFoundException.class)
                    .hasMessage(
                            ANIME_NOT_FOUND_BY_STUDIO.getMessage().formatted(StringUtils.reverse(studioName))
                    );
        });
    }

}