package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.ports.repository.MangaRepository;
import br.com.devotaku.shared.usecase.UseCase;

import java.util.List;

public record FindAllByFinishedUseCase(
        MangaRepository mangaRepository
) implements UseCase<FindAllByFinishedUseCase.InputValues, FindAllByFinishedUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var pageInfo = input.pageInfo();

        return new OutputValues(
                mangaRepository.findAllByFinished(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Manga> mangas) implements UseCase.OutputValues {
    }

}
