package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.entity.value.object.Identifier;
import br.com.devotaku.animedomain.ports.repository.AnimeRepository;
import br.com.devotaku.animedomain.usecase.execption.EntityNotFoundException;
import br.com.devotaku.animedomain.usecase.execption.Field;
import br.com.devotaku.shared.usecase.UseCase;

public record FindByIdUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByIdUseCase.InputValues, FindByIdUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        Identifier id = new Identifier(input.id());

        return animeRepository
                .findById(id)
                .map(OutputValues::new)
                .orElseThrow(() -> new EntityNotFoundException(
                        Anime.class,
                        new Field("id", id.value()))
                );
    }

    public record InputValues(Long id) implements UseCase.InputValues {
    }

    public record OutputValues(Anime anime) implements UseCase.OutputValues {
    }

}
