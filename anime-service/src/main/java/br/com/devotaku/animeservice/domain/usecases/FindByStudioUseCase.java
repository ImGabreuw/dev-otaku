package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;

import static br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException.MessageTemplate.ANIME_NOT_FOUND_BY_STUDIO;

public record FindByStudioUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByStudioUseCase.InputValues, FindByStudioUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var pageInfo = input.pageInfo();
        var studioName = input.studioName();

        var result = animeRepository.findByStudio(studioName, pageInfo);

        if (result.isEmpty()) {
            throw new AnimeNotFoundException(
                    ANIME_NOT_FOUND_BY_STUDIO.getMessage().formatted(studioName)
            );
        }

        return new OutputValues(result);
    }

    public record InputValues(String studioName, PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animeList) implements UseCase.OutputValues {
    }

}
