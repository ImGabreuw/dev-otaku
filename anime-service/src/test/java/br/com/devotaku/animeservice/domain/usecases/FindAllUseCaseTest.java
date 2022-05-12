package br.com.devotaku.animeservice.domain.usecases;

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
class FindAllUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindAllUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindAllUseCase(animeRepository);
    }

    @DisplayName("Should execute FindAllUseCase")
    @Test
    void shouldExecuteFindAllUseCase() {
        var page = PageInfo.createDefault();
        var input = new FindAllUseCase.InputValues(page);

        var result = underTest.execute(input);

        assertThat(result.animeList()).hasSize(page.pageSize());
        assertThat(result.animeList()).doesNotContainNull();

        result.animeList().forEach(System.out::println);
    }

}