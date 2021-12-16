package br.com.devotaku.comicdomain.usecase.webtoon;

import br.com.devotaku.comicdomain.entity.WebToon;
import br.com.devotaku.comicdomain.gateway.repository.WebToonRepository;
import br.com.devotaku.comicdomain.usecase.UseCase;
import br.com.devotaku.comicdomain.usecase.exception.EntityNotFoundException;
import br.com.devotaku.comicdomain.usecase.exception.Field;

public record FindByTitleOrAlternativesNameUseCase(
        WebToonRepository webToonRepository
) implements UseCase<FindByTitleOrAlternativesNameUseCase.InputValues, FindByTitleOrAlternativesNameUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        String webToonName = input.webToonName();

        return webToonRepository
                .findByTitleOrAlternativesName(webToonName)
                .map(OutputValues::new)
                .orElseThrow(() -> new EntityNotFoundException(
                        WebToon.class,
                        new Field("title", webToonName),
                        new Field("alternativeNames", webToonName)
                ));
    }

    public record InputValues(String webToonName) implements UseCase.InputValues {
    }

    public record OutputValues(WebToon webToon) implements UseCase.OutputValues {
    }

}
