package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.devotaku.animeservice.shared.exceptions.EntityNotFoundException.MessageTemplate.ENTITY_NOT_FOUND_BY_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FindByIdUseCaseTest {

    @Autowired
    private AnimeRepository animeRepository;

    private FindByIdUseCase underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindByIdUseCase(animeRepository);
    }

    @DisplayName("Should execute FindByIdUseCase")
    @Test
    void shouldExecuteFindByIdUseCase() {
        var id = 1L;
        var input = new FindByIdUseCase.InputValues(id);

        var output = underTest.execute(input);

        assertThat(output.anime().getId().value()).isEqualTo(id);
    }

    @DisplayName("Should throw EntityNotFoundException because don't exist anime with id 1")
    @Test
    void shouldThrowEntityNotFoundExceptionBecauseDonTExistAnimeWithId1() {
        var id = 100L;
        var input = new FindByIdUseCase.InputValues(id);

        assertThatThrownBy(() -> underTest.execute(input))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage(ENTITY_NOT_FOUND_BY_ID.getMessage().formatted(id));
    }

}