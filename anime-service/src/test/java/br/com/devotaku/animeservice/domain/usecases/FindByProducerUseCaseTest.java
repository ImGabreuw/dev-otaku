package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.value.objects.Producer;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindByProducerUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindByProducerUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByProducerUseCase(animeRepository);
    }

    @DisplayName("Should execute FindByProducerUseCase")
    @Test
    void shouldExecuteFindByProducerUseCase() {
        var page = PageInfo.createDefault();
        var animeFromDb = animeRepository
                .findById(1L)
                .orElseThrow();

        var producersName = animeFromDb
                .getProducers()
                .stream()
                .map(Producer::value)
                .toList();


        producersName.forEach(producerName -> {
            var input = new FindByProducerUseCase.InputValues(producerName, page);

            var output = underTest.execute(input);

            assertThat(output.animeList()).containsExactly(animeFromDb);
        });
    }

    @DisplayName("Should throw AnimeNotFoundException because was not found any anime with this producer name")
    @Test
    void shouldThrowAnimeNotFoundExceptionBecauseWasNotFoundAnyAnimeWithThisProducerName() {
        var page = PageInfo.createDefault();
        var animeFromDb = animeRepository
                .findById(1L)
                .orElseThrow();

        var producersName = animeFromDb
                .getProducers()
                .stream()
                .map(Producer::value)
                .toList();


        producersName.forEach(producerName -> {
            var input = new FindByProducerUseCase.InputValues(StringUtils.reverse(producerName), page);

            assertThatThrownBy(() -> underTest.execute(input))
                    .isInstanceOf(AnimeNotFoundException.class)
                    .hasMessage("Do not exist any anime with producer named (%s).".formatted(StringUtils.reverse(producerName)));
        });
    }

}