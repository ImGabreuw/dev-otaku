package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.gateway.repository.ManhwaRepository;
import br.com.devotaku.comicdomain.usecase.UseCase;

import java.util.List;

public record FetchTopUseCase(
        ManhwaRepository manhwaRepository
) implements UseCase<FetchTopUseCase.InputValues, FetchTopUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        PageInfo pageInfo = input.pageInfo();

        return new OutputValues(
                manhwaRepository.fetchTopUseCase(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Manhwa> manhwas) implements UseCase.OutputValues {
    }

}
