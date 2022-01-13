package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.ports.repository.AnimeRepository;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.shared.usecase.UseCase;

import java.util.List;

public record FindAllUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindAllUseCase.InputValues, FindAllUseCase.OutPutValues> {

    @Override
    public OutPutValues execute(InputValues input) {
        PageInfo pageInfo = input.pageInfo();

        return new OutPutValues(
                animeRepository.findAll(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutPutValues(List<Anime> animes) implements UseCase.OutputValues {
    }

}
