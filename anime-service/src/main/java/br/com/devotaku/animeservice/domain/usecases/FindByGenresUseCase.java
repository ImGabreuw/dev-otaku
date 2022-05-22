package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;
import java.util.Set;

public record FindByGenresUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByGenresUseCase.InputValues, FindByGenresUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var pageInfo = input.pageInfo();
        var genres = input.genres();

        return new OutputValues(
                animeRepository.findByGenres(genres, pageInfo)
        );
    }

    public record InputValues(Set<Genre> genres, PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animeList) implements UseCase.OutputValues {
    }

}