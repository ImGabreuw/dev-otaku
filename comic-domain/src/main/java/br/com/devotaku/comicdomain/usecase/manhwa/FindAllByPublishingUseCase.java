package br.com.devotaku.comicdomain.usecase.manhwa;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.ports.repository.ManhwaRepository;
import br.com.devotaku.shared.usecase.UseCase;

import java.util.List;

public record FindAllByPublishingUseCase(
        ManhwaRepository manhwaRepository
) implements UseCase<FindAllByPublishingUseCase.InputValues, FindAllByPublishingUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        var pageInfo = input.pageInfo();

        return new OutputValues(
                manhwaRepository.findAllByPublishing(pageInfo)
        );
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues(List<Manhwa> manhwas) implements UseCase.OutputValues {
    }

}
