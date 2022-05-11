package br.com.devotaku.animeservice.application.dataprovider.entities;

import br.com.devotaku.animeservice.application.config.jpa.converter.GenreConverter;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.entities.enums.SourceType;
import br.com.devotaku.animeservice.domain.entities.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@NoArgsConstructor
@Data
public class AnimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ElementCollection
    private Set<String> alternativeNames;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private Integer episodes;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDate launchedAt;

    private LocalDate endedAt;

    @ElementCollection
    private Set<String> producers;

    @ElementCollection
    private Set<String> studios;

    @Column(nullable = false)
    private SourceType source;

    @ElementCollection
    @Convert(converter = GenreConverter.class)
    private List<Genre> genres;

    public AnimeEntity(Long id, String title, Set<String> alternativeNames, String description, Double score, Integer episodes, Status status, LocalDate launchedAt, LocalDate endedAt, Set<String> producers, Set<String> studios, SourceType source, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.alternativeNames = alternativeNames == null ? new HashSet<>() : alternativeNames;
        this.description = description;
        this.score = score;
        this.episodes = episodes;
        this.status = status;
        this.launchedAt = launchedAt;
        this.endedAt = endedAt;
        this.producers = producers;
        this.studios = studios == null ? new HashSet<>() : studios;
        this.source = source;
        this.genres = genres == null ? new ArrayList<>() : genres;
    }

}
