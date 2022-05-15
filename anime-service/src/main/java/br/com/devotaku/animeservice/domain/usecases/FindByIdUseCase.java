package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException;

import static br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException.MessageTemplate.ANIME_NOT_FOUND_BY_ID;

public record FindByIdUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByIdUseCase.InputValues, FindByIdUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var id = input.id();

        var anime = animeRepository
                .findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(ANIME_NOT_FOUND_BY_ID.getMessage().formatted(id)));

        return new OutputValues(anime);
    }

    public record InputValues(Long id) implements UseCase.InputValues {
    }

    public record OutputValues(Anime anime) implements UseCase.OutputValues {
    }

}
