package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.ports.repository.AnimeRepository;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.shared.usecase.UseCase;

import java.util.List;

public record FindAllByFinishedUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindAllByFinishedUseCase.InputValues, FindAllByFinishedUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var pageInfo = input.pageInfo();

        return new OutputValues(
                animeRepository.findAllByFinished(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animes) implements UseCase.OutputValues {
    }

}
