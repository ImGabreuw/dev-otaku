package br.com.devotaku.animedomain.usecase;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.ports.repository.AnimeRepository;
import br.com.devotaku.animedomain.usecase.execption.EntityNotFoundException;
import br.com.devotaku.animedomain.usecase.execption.Field;
import br.com.devotaku.animedomain.usecase.execption.IllegalInputException;
import br.com.devotaku.shared.usecase.UseCase;
import org.apache.commons.lang3.StringUtils;

public record FindByTitleOrAlternativesNameUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByTitleOrAlternativesNameUseCase.InputValues, FindByTitleOrAlternativesNameUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        String animeName = input.animeName();

        if (StringUtils.isBlank(animeName)) {
            throw new IllegalInputException(
                    FindByTitleOrAlternativesNameUseCase.InputValues.class,
                    new Field("animeName", animeName)
            );
        }

        return animeRepository
                .findByTitleOrAlternativesName(animeName)
                .map(OutputValues::new)
                .orElseThrow(() -> new EntityNotFoundException(
                        Anime.class,
                        new Field("title", animeName),
                        new Field("alternativeNames", animeName)
                ));
    }

    public record InputValues(String animeName) implements UseCase.InputValues {
    }

    public record OutputValues(Anime anime) implements UseCase.OutputValues {
    }

}
