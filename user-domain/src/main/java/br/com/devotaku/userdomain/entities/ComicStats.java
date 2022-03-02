package br.com.devotaku.userdomain.entities;

import br.com.devotaku.shared.validation.SelfValidation;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashMap;
import java.util.Map;

@Data
public class ComicStats implements SelfValidation<ComicStats> {

    // FIXME: 18/01/2022 Substituir "Map" por Regis (criar um contrato: "CacheRepository")
    private final Map<Long, ComicInfoSummary> cache = new HashMap<>();

    @NotNull(message = "O campo 'Count' é obrigatório")
    @PositiveOrZero(message = "O campo 'Count' deve conter um número inteiro maior ou igual a 0")
    private Integer count;

    @NotNull(message = "O campo 'Reading' é obrigatório")
    @PositiveOrZero(message = "O campo 'Reading' deve conter um número inteiro maior ou igual a 0")
    private Integer reading;

    @NotNull(message = "O campo 'Completed' é obrigatório")
    @PositiveOrZero(message = "O campo 'Completed' deve conter um número inteiro maior ou igual a 0")
    private Integer completed;

    @NotNull(message = "O campo 'PlanToRead' é obrigatório")
    @PositiveOrZero(message = "O campo 'PlanToRead' deve conter um número inteiro maior ou igual a 0")
    private Integer planToRead;

    public ComicStats() {
        this(0, 0, 0, 0);
    }

    public ComicStats(Integer count, Integer reading, Integer completed, Integer planToRead) {
        this.count = count;
        this.reading = reading;
        this.completed = completed;
        this.planToRead = planToRead;

        validate(this);
    }

}
