package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;

import static br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException.MessageTemplate.ANIME_NOT_FOUND_BY_TITLE_OR_ALTERNATIVE_NAMES;

public record FindByTitleOrAlternativeNamesUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByTitleOrAlternativeNamesUseCase.InputValues, FindByTitleOrAlternativeNamesUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var animeName = input.animeName();
        var pageInfo = input.pageInfo();

        var result = animeRepository.findByTitleOrAlternativeNames(animeName, pageInfo);

        if (result.isEmpty()) {
            throw new AnimeNotFoundException(
                    ANIME_NOT_FOUND_BY_TITLE_OR_ALTERNATIVE_NAMES.getMessage().formatted(animeName)
            );
        }

        return new OutputValues(result);
    }

    public record InputValues(String animeName, PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animeList) implements UseCase.OutputValues {
    }

}