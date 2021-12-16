package br.com.devotaku.comicdomain.usecase.webtoon;

import br.com.devotaku.comicdomain.entity.WebToon;
import br.com.devotaku.comicdomain.entity.pagination.PageInfo;
import br.com.devotaku.comicdomain.gateway.repository.WebToonRepository;
import br.com.devotaku.comicdomain.usecase.UseCase;

import java.util.List;

public record FetchTopUseCase(
        WebToonRepository webToonRepository
) implements UseCase<FetchTopUseCase.InputValues, FetchTopUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        PageInfo pageInfo = input.pageInfo();

        return new OutputValues(
                webToonRepository.fetchTopUseCase(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<WebToon> webToons) implements UseCase.OutputValues {
    }

}
