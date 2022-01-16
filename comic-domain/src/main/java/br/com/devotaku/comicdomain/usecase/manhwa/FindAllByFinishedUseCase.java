package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.ports.repository.ManhwaRepository;
import br.com.devotaku.shared.usecase.UseCase;

import java.util.List;

public record FindAllByFinishedUseCase(
        ManhwaRepository manhwaRepository
) implements UseCase<FindAllByFinishedUseCase.InputValues, FindAllByFinishedUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var pageInfo = input.pageInfo();

        return new OutputValues(
                manhwaRepository.findAllByFinished(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Manhwa> manhwas) implements UseCase.OutputValues {
    }

}
