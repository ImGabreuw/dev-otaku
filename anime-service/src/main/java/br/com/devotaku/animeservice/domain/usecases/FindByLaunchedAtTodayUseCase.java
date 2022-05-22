package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;

public record FindByLaunchedAtTodayUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByLaunchedAtTodayUseCase.InputValues, FindByLaunchedAtTodayUseCase.OutputValues> {

    @Override
    public FindByLaunchedAtTodayUseCase.OutputValues execute(FindByLaunchedAtTodayUseCase.InputValues input) {
        var pageInfo = input.pageInfo();

        return new OutputValues(
                animeRepository.findByLaunchedAtToday(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animeList) implements UseCase.OutputValues {
    }

}