package br.com.devotaku.comicdomain.usecase.webtoon;

import br.com.devotaku.comicdomain.entity.WebToon;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.ports.repository.WebToonRepository;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import br.com.devotaku.comicdomain.usecase.exception.Field;
import br.com.devotaku.shared.usecase.UseCase;

public record FindByIdUseCase(
        WebToonRepository webToonRepository
) implements UseCase<FindByIdUseCase.InputValues, FindByIdUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var id = input.id();

        return webToonRepository
                .findById(id)
                .map(OutputValues::new)
                .orElseThrow(() -> new EntityNotFoundException(
                        WebToon.class,
                        new Field("id", id.value())
                ));
    }

    public record InputValues(Identifier id) implements UseCase.InputValues {
    }

    public record OutputValues(WebToon webToon) implements UseCase.OutputValues {
    }

}
