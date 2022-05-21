package br.com.devotaku.animeservice.domain.usecases;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;

import static br.com.devotaku.animeservice.shared.exceptions.AnimeNotFoundException.MessageTemplate.DO_NOT_EXIST_ANY_ANIME_WITH_PRODUCERS;

public record FindByProducerUseCase(
        AnimeRepository animeRepository
) implements UseCase<FindByProducerUseCase.InputValues, FindByProducerUseCase.OutputValues> {

    @Override
    public FindByProducerUseCase.OutputValues execute(FindByProducerUseCase.InputValues input) {
        var producerName = input.producerName();
        var pageInfo = input.pageInfo();

        var result = animeRepository.findByProducer(producerName, pageInfo);

        if (result.isEmpty()) {
            throw new AnimeNotFoundException(
                    DO_NOT_EXIST_ANY_ANIME_WITH_PRODUCERS.getMessage().formatted(producerName)
            );
        }

        return new OutputValues(result);
    }

    public record InputValues(String producerName, PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Anime> animeList) implements UseCase.OutputValues {
    }

}