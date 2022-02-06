package br.com.devotaku.userdomain.entities;

import br.com.devotaku.shared.validation.SelfValidation;
import br.com.devotaku.userdomain.entities.value.objects.AnimeInfoSummary;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashMap;
import java.util.Map;

@Data
public class AnimeStats implements SelfValidation<AnimeStats> {

    // FIXME: 18/01/2022 Substituir "Map" por Regis (criar um contrato: "CacheRepository")
    private final Map<Long, AnimeInfoSummary> cache = new HashMap<>();

    @NotNull(message = "O campo 'Count' é obrigatório")
    @PositiveOrZero(message = "O campo 'Count' deve conter um número inteiro maior ou igual a 0")
    private Integer count;

    @NotNull(message = "O campo 'Reading' é obrigatório")
    @PositiveOrZero(message = "O campo 'Reading' deve conter um número inteiro maior ou igual a 0")
    private Integer watching;

    @NotNull(message = "O campo 'Completed' é obrigatório")
    @PositiveOrZero(message = "O campo 'Completed' deve conter um número inteiro maior ou igual a 0")
    private Integer completed;

    @NotNull(message = "O campo 'PlanToRead' é obrigatório")
    @PositiveOrZero(message = "O campo 'PlanToRead' deve conter um número inteiro maior ou igual a 0")
    private Integer planToWatch;

    public AnimeStats() {
        this(0, 0, 0, 0);
    }

    public AnimeStats(Integer count, Integer watching, Integer completed, Integer planToWatch) {
        this.count = count;
        this.watching = watching;
        this.completed = completed;
        this.planToWatch = planToWatch;

        validate(this);
    }

}
