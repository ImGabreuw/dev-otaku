package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;

public record FindByStatusFinishedUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByStatusFinishedUseCase.InputValues, FindByStatusFinishedUseCase.OutputValues> {

    @Override
    public FindByStatusFinishedUseCase.OutputValues execute(FindByStatusFinishedUseCase.InputValues input) {
        var pageInfo = input.pageInfo();

        return new OutputValues(
                animeRepository.findByStatusFinished(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animeList) implements UseCase.OutputValues {
    }

}