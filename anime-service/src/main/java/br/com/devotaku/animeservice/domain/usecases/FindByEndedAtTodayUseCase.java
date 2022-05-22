package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;

public record FindByEndedAtTodayUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByEndedAtTodayUseCase.InputValues, FindByEndedAtTodayUseCase.OutputValues> {

    @Override
    public FindByEndedAtTodayUseCase.OutputValues execute(FindByEndedAtTodayUseCase.InputValues input) {
        var pageInfo = input.pageInfo();

        return new OutputValues(
                animeRepository.findByEndedAtToday(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animeList) implements UseCase.OutputValues {
    }

}