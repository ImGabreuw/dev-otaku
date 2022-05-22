package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;

public record FindByLaunchedAtToday(
        AnimeRepository animeRepository
) implements UseCase<FindByLaunchedAtToday.InputValues, FindByLaunchedAtToday.OutputValues> {

    @Override
    public FindByLaunchedAtToday.OutputValues execute(FindByLaunchedAtToday.InputValues input) {
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