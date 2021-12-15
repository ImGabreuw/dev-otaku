package br.com.devotaku.comicdomain.usecase.manga;

import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.gateway.repository.MangaRepository;
import br.com.devotaku.comicdomain.usecase.UseCase;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import br.com.devotaku.comicdomain.usecase.exception.Field;

public record FindByIdUseCase(
        MangaRepository mangaRepository
) implements UseCase<FindByIdUseCase.InputValues, FindByIdUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        Identifier id = input.identifier();

        return mangaRepository.findById(id)
                .map(OutputValues::new)
                .orElseThrow(() -> new EntityNotFoundException(
                        Manga.class,
                        new Field("id", id.value())
                ));
    }

    public record InputValues(Identifier identifier) implements UseCase.InputValues {
    }

    public record OutputValues(Manga manga) implements UseCase.OutputValues {
    }

}
