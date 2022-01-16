package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.comicdomain.ports.repository.ManhwaRepository;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import br.com.devotaku.comicdomain.usecase.exception.Field;
import br.com.devotaku.shared.usecase.UseCase;

public record FindByTitleOrAlternativesNameUseCase(
        ManhwaRepository manhwaRepository
) implements UseCase<FindByTitleOrAlternativesNameUseCase.InputValues, FindByTitleOrAlternativesNameUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var manhwaName = input.manhwaName();

        return manhwaRepository
                .findByTitleOrAlternativesName(manhwaName)
                .map(OutputValues::new)
                .orElseThrow(() -> new EntityNotFoundException(
                        Manhwa.class,
                        new Field("title", manhwaName),
                        new Field("alternativeNames", manhwaName)
                ));
    }

    public record InputValues(String manhwaName) implements UseCase.InputValues {
    }

    public record OutputValues(Manhwa manhwa) implements UseCase.OutputValues {
    }

}
