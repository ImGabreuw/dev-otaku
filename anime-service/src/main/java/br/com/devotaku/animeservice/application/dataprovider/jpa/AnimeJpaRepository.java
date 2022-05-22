package br.com.devotaku.animeservice.application.dataprovider.jpa;

import br.com.devotaku.animeservice.application.dataprovider.entities.AnimeEntity;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.entities.enums.SourceType;
import br.com.devotaku.animeservice.domain.entities.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AnimeJpaRepository extends JpaRepository<AnimeEntity, Long> {

    /**
     * Retrieve all paginated anime containing a specific {@link br.com.devotaku.animeservice.domain.entities.value.objects.Title} ordered by score (descendent) and title (ascending)
     *
     * @param title    {@link String}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findByTitleIsLikeIgnoreCase(String title, Pageable pageable);

    /**
     * Retrieve all paginated anime containing a specific {@link br.com.devotaku.animeservice.domain.entities.value.objects.AlternativeName} ordered by score (descendent) and title (ascending)
     *
     * @param alternativeNames {@link String}
     * @param pageable         {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findDistinctByAlternativeNamesIsLikeIgnoreCase(String alternativeNames, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific {@link br.com.devotaku.animeservice.domain.entities.value.objects.Producer} ordered by score (descendent) and title (ascending)
     *
     * @param producerName {@link String}
     * @param pageable     {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findByProducersIsLikeIgnoreCase(String producerName, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific {@link br.com.devotaku.animeservice.domain.entities.value.objects.Studio} ordered by score (descendent) and title (ascending)
     *
     * @param studioName {@link String}
     * @param pageable   {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findByStudiosIsLikeIgnoreCase(String studioName, Pageable pageable);

    /**
     * Retrieve the top 10 anime
     *
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findTopByOrderByScoreDesc(Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific {@link Status} ordered by score (descendent) and title (ascending)
     *
     * @param status   {@link Status}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findByStatusIsLike(Status status, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific <code>launchedAt</code> date ordered by score (descendent) and title (ascending)
     *
     * @param launchedAt {@link LocalDate}
     * @param pageable   {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findByLaunchedAtEquals(LocalDate launchedAt, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific date range ordered by score (descendent) and title (ascending)
     *
     * @param start    {@link LocalDate}
     * @param end      {@link LocalDate}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findByLaunchedAtIsBetween(LocalDate start, LocalDate end, Pageable pageable);

    /**
     * Retrieve all paginated anime launched at a specific month ordered by score (descendent) and title (ascending)
     *
     * @param month    {@link java.time.Month}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findByLaunchedAtMonthValue(int month, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific <code>endedAt</code> date ordered by score (descendent) and title (ascending)
     *
     * @param launchedAt {@link LocalDate}
     * @param pageable   {@link LocalDate}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByEndedAt(LocalDate launchedAt, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific {@link SourceType} ordered by score (descendent) and title (ascending)
     *
     * @param source   {@link SourceType}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesBySource(SourceType source, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific or a set of {@link Genre} ordered by score (descendent) and title (ascending)
     *
     * @param genres   Use <code>convertGenresToString()</code> method from {@link Genre} to convert a list of genre into a String
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    @SuppressWarnings("SpringDataRepositoryMethodParametersInspection")
    Page<AnimeEntity> findAnimeEntitiesByGenres(String genres, Pageable pageable);

}
