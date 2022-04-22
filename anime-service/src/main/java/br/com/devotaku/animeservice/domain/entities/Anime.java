package br.com.devotaku.animeservice.domain.entities;

import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.entities.enums.SourceType;
import br.com.devotaku.animeservice.domain.entities.enums.Status;
import br.com.devotaku.animeservice.domain.entities.value.objects.*;
import br.com.devotaku.animeservice.shared.validation.SelfValidation;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static br.com.devotaku.animeservice.domain.entities.enums.Status.FINISHED;
import static br.com.devotaku.animeservice.domain.entities.enums.Status.PUBLISHING;

@Data
public class Anime implements SelfValidation<Anime> {

    @NotNull
    private Identifier id;

    @NotNull
    private Title title;

    private Set<AlternativeName> alternativeNames;

    @NotNull
    private Description description;

    @NotNull
    private Score score;

    @NotNull
    private Episodes episodes;

    @NotNull
    private Status status;

    @NotNull
    private LocalDate launchedAt;

    @NotNull
    private LocalDate endedAt;

    private Set<Producer> producers;

    @Size(min = 1)
    private Set<Studio> studios;

    @NotNull
    private SourceType source;

    @Size(min = 1)
    private List<Genre> genres;

    public Anime(Identifier id, Title title, Set<AlternativeName> alternativeNames, Description description, Score score, Episodes episodes, Status status, LocalDate launchedAt, LocalDate endedAt, Set<Producer> producers, Set<Studio> studios, SourceType source, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.alternativeNames = alternativeNames == null ? new HashSet<>() : alternativeNames;
        this.description = description;
        this.score = score;
        this.episodes = episodes;
        this.status = status;
        this.launchedAt = launchedAt;
        this.endedAt = endedAt;
        this.producers = producers == null ? new HashSet<>() : producers;
        this.studios = studios == null ? new HashSet<>() : studios;
        this.source = source;
        this.genres = genres == null ? new ArrayList<>() : genres;

        validate(this);
    }

    public boolean hasTitleOrAlternativeNamesEqualsTo(String animeName) {
        return this.title.value().equalsIgnoreCase(animeName) ||
                this.alternativeNames.stream().anyMatch(alternativeName -> alternativeName.value().equalsIgnoreCase(animeName));
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

    public void addAlternativeName(String alternativeName) {
        AlternativeName newAlternativeName = new AlternativeName(alternativeName);

        if (!this.alternativeNames.add(newAlternativeName)) {
            throw new IllegalArgumentException(
                    "Alternative name (%s) already exists.".formatted(alternativeName)
            );
        }
    }

    public void removeAlternativeName(String alternativeName) {
        if (alternativeName == null) {
            throw new IllegalArgumentException("Alternative name must not be null.");
        }

        boolean removed = this.alternativeNames
                .removeIf(existAlternativeName -> existAlternativeName.value().equalsIgnoreCase(alternativeName));

        if (!removed) {
            throw new IllegalArgumentException(
                    "Alternative name (%s) does not exist.".formatted(alternativeName)
            );
        }
    }

    public void addProducer(String producerName) {
        Producer newProducer = new Producer(producerName);

        if (!this.producers.add(newProducer)) {
            throw new IllegalArgumentException(
                    "Producer named (%s) already exists.".formatted(producerName)
            );
        }
    }

    public void removeProducer(String producerName) {
        if (producerName == null) {
            throw new IllegalArgumentException("Producer name must not be null.");
        }

        boolean removed = this.producers
                .removeIf(existProducer -> existProducer.value().equalsIgnoreCase(producerName));

        if (!removed) {
            throw new IllegalArgumentException(
                    "Producer named (%s) does not exist.".formatted(producerName)
            );
        }
    }

    public void addStudio(String studioName) {
        Studio newStudio = new Studio(studioName);

        if (!this.studios.add(newStudio)) {
            throw new IllegalArgumentException(
                    "Studio named (%s) already exists.".formatted(studioName)
            );
        }
    }

    public void removeStudio(String studioName) {
        if (studioName == null) {
            throw new IllegalArgumentException("Studio name must not be null.");
        }

        boolean removed = this.studios
                .removeIf(existStudio -> existStudio.value().equalsIgnoreCase(studioName));

        if (!removed) {
            throw new IllegalArgumentException(
                    "Studio named (%s) does not exist.".formatted(studioName)
            );
        }
    }

}
