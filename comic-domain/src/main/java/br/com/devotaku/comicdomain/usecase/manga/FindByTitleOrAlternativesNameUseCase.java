package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.comicdomain.ports.repository.MangaRepository;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import br.com.devotaku.comicdomain.usecase.exception.Field;
import br.com.devotaku.shared.usecase.UseCase;

public record FindByTitleOrAlternativesNameUseCase(
        MangaRepository mangaRepository
) implements UseCase<FindByTitleOrAlternativesNameUseCase.InputValues, FindByTitleOrAlternativesNameUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var mangaName = input.mangaName();

        return mangaRepository
                .findByTitleOrAlternativesName(mangaName)
                .map(OutputValues::new)
                .orElseThrow(() -> new EntityNotFoundException(
                        Manga.class,
                        new Field("title", mangaName),
                        new Field("alternativeNames", mangaName)
                ));
    }

    public record InputValues(String mangaName) implements UseCase.InputValues {
    }

    public record OutputValues(Manga manga) implements UseCase.OutputValues {
    }

}
