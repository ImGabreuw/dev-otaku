package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;

public record FindByStatusPublishingUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByStatusPublishingUseCase.InputValues, FindByStatusPublishingUseCase.OutputValues> {

    @Override
    public FindByStatusPublishingUseCase.OutputValues execute(FindByStatusPublishingUseCase.InputValues input) {
        var pageInfo = input.pageInfo();

        return new OutputValues(
                animeRepository.findByStatusPublishing(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animeList) implements UseCase.OutputValues {
    }

}