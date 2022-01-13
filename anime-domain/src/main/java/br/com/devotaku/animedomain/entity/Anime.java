package br.com.devotaku.animedomain.entity;

import br.com.devotaku.animedomain.entity.enums.Genre;
import br.com.devotaku.animedomain.entity.enums.SourceType;
import br.com.devotaku.animedomain.entity.enums.Status;
import br.com.devotaku.animedomain.entity.value.object.AlternativeName;
import br.com.devotaku.animedomain.entity.value.object.Identifier;
import br.com.devotaku.animedomain.entity.value.object.Producer;
import br.com.devotaku.animedomain.entity.value.object.Studio;
import br.com.devotaku.shared.number.NumberHelper;
import br.com.devotaku.shared.validation.SelfValidation;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.devotaku.animedomain.entity.enums.Status.FINISHED;
import static br.com.devotaku.animedomain.entity.enums.Status.PUBLISHING;

@Data
public class Anime implements SelfValidation<Anime>, Cloneable, Comparable<Anime> {

    @NotNull(message = "O campo 'id' é obrigatório")
    private Identifier id;

    @NotBlank(message = "O campo 'title' é obrigatório")
    private String title;

    private Set<AlternativeName> alternativeNames;

    @NotBlank(message = "O campo 'description' é obrigatório")
    private String description;

    @NotNull(message = "O campo 'score' é obrigatório")
    @DecimalMin(value = "0.00", message = "O campo 'score' deve conter um número maior ou igual a '{1}'")
    @DecimalMax(value = "10.00", message = "O campo 'score' deve conter um número menor ou igual a '{1}'")
    private Double score;

    @NotNull(message = "O campo 'episodes' é obrigatório")
    @Positive(message = "O campo 'episodes' deve conter um número maior ou igual a 1")
    private Integer episodes;

    @NotNull(message = "O campo 'status' é obrigatório")
    private Status status;

    @NotNull(message = "O campo 'launchedAt' é obrigatório")
    private LocalDate launchedAt;

    @NotNull(message = "O campo 'endedAt' é obrigatório")
    private LocalDate endedAt;

    @NotNull(message = "O campo 'producers' é obrigatório")
    @Size(min = 1, message = "O campo 'score' deve conter pelo menos {1} produtor")
    private Set<Producer> producers;

    @NotNull(message = "O campo 'studios' é obrigatório")
    @Size(min = 1, message = "O campo 'studios' deve conter pelo menos {1} estúdio")
    private Set<Studio> studios;

    @NotNull(message = "O campo 'source' é obrigatório")
    private SourceType source;

    @NotNull(message = "O campo 'genres' é obrigatório")
    @Size(min = 1, message = "O campo 'genres' deve conter pelo menos {1} gênero")
    private List<Genre> genres;

    public Anime(Identifier id, String title, Set<AlternativeName> alternativeNames, String description, Double score, Integer episodes, Status status, LocalDate launchedAt, LocalDate endedAt, Set<Producer> producers, Set<Studio> studios, SourceType source, List<Genre> genres) {
        this.id = id;
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

    @Override
    public Anime clone() {
        try {
            return (Anime) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(Anime anime) {
        return Double.compare(this.score, anime.getScore());
    }

    public boolean hasTitleOrAlternativeNamesEqualsTo(String animeName) {
        return this.title.equalsIgnoreCase(animeName) ||
                this.alternativeNames.stream().anyMatch(alternativeName -> alternativeName.name().equalsIgnoreCase(animeName));
    }

    public void finished() {
        status = FINISHED;
    }

    public boolean isFinished() {
        return status == FINISHED;
    }

    public boolean isPublishing() {
        return status == PUBLISHING;
    }

    public static <T extends Anime> List<T> generateRandomScore(T baseEntity, long limit) {
        RandomGenerator generator = RandomGenerator.getDefault();

        return Stream.iterate(baseEntity, entity -> {
                    Anime clone = entity.clone();
                    clone.setScore(
                            NumberHelper.formatWith2Digits(generator.nextDouble(10.00))
                    );

                    return (T) clone;
                })
                .limit(limit)
                .collect(Collectors.toList());
    }
}
