package br.com.devotaku.animedomain.entity;

import br.com.devotaku.animedomain.entity.enums.Genre;
import br.com.devotaku.animedomain.entity.enums.SourceType;
import br.com.devotaku.animedomain.entity.enums.Status;
import br.com.devotaku.animedomain.entity.value.object.AlternativeName;
import br.com.devotaku.animedomain.entity.value.object.Producer;
import br.com.devotaku.animedomain.entity.value.object.Studio;
import br.com.devotaku.shared.validation.SelfValidation;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class Anime implements SelfValidation<Anime> {

    @NotBlank
    private String title;

    private Set<AlternativeName> alternativeNames;

    @NotBlank
    private String description;

    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("10.00")
    private Double score;

    @NotNull
    @Positive
    private Integer episodes;

    @NotNull
    private Status status;

    @NotNull
    private LocalDate launchedAt;

    @NotNull
    private LocalDate endedAt;

    @Size(min = 1)
    private Set<Producer> producers;

    @Size(min = 1)
    private Set<Studio> studios;

    @NotNull
    private SourceType source;

    @Size(min = 1)
    private List<Genre> genres;

    public Anime(String title, Set<AlternativeName> alternativeNames, String description, Double score, Integer episodes, Status status, LocalDate launchedAt, LocalDate endedAt, Set<Producer> producers, Set<Studio> studios, SourceType source, List<Genre> genres) {
        this.title = title;
        this.alternativeNames = alternativeNames;
        this.description = description;
        this.score = score;
        this.episodes = episodes;
        this.status = status;
        this.launchedAt = launchedAt;
        this.endedAt = endedAt;
        this.producers = producers;
        this.studios = studios;
        this.source = source;
        this.genres = genres;

        validate(this);
    }

}
