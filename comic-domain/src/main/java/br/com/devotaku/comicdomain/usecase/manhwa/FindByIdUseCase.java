package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.ports.repository.ManhwaRepository;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import br.com.devotaku.comicdomain.usecase.exception.Field;
import br.com.devotaku.shared.usecase.UseCase;

public record FindByIdUseCase(
        ManhwaRepository manhwaRepository
) implements UseCase<FindByIdUseCase.InputValues, FindByIdUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var id = input.id();

        return manhwaRepository
                .findById(id)
                .map(OutputValues::new)
                .orElseThrow(() -> new EntityNotFoundException(Manhwa.class, new Field("id", id.value())));
    }

    public record InputValues(Identifier id) implements UseCase.InputValues {
    }

    public record OutputValues(Manhwa manhwa) implements UseCase.OutputValues {
    }

}
