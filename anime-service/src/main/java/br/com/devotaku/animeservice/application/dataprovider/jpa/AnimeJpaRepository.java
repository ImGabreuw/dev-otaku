package br.com.devotaku.animeservice.application.dataprovider.jpa;

import br.com.devotaku.animeservice.application.dataprovider.entities.AnimeEntity;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.entities.enums.SourceType;
import br.com.devotaku.animeservice.domain.entities.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AnimeJpaRepository extends JpaRepository<AnimeEntity, Long> {

    /**
     * Retrieve all paginated anime containing a specific {@link br.com.devotaku.animeservice.domain.entities.value.objects.Title} ordered by score (descendent) and title (ascending)
     *
     * @param title {@link String}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByTitleIsLikeIgnoreCaseByTitleIsLikeIgnoreCaseOrderByScoreDescTitleAsc(String title, Pageable pageable);

    /**
     * Retrieve all paginated anime containing a specific {@link br.com.devotaku.animeservice.domain.entities.value.objects.AlternativeName} ordered by score (descendent) and title (ascending)
     *
     * @param alternativeName {@link String}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByAlternativeNamesContainingIgnoreCaseOrderByScoreDescTitleAsc(String alternativeName, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific {@link br.com.devotaku.animeservice.domain.entities.value.objects.Producer} ordered by score (descendent) and title (ascending)
     *
     * @param producerName {@link String}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByProducersContainingIgnoreCaseOrderByScoreDescTitleAsc(String producerName, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific {@link br.com.devotaku.animeservice.domain.entities.value.objects.Studio} ordered by score (descendent) and title (ascending)
     *
     * @param studioName {@link String}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByStudiosContainingIgnoreCaseOrderByScoreDescTitleAsc(String studioName, Pageable pageable);

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
     * @param status {@link Status}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByStatusOrderByScoreDescTitleAsc(Status status, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific <code>launchedAt</code> date ordered by score (descendent) and title (ascending)
     *
     * @param launchedAt {@link LocalDate}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByLaunchedAtOrderByScoreDescTitleAsc(LocalDate launchedAt, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific season (date range) ordered by score (descendent) and title (ascending)
     *
     * @param start {@link LocalDate}
     * @param end {@link LocalDate}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByLaunchedAtBetweenOrderByScoreDescTitleAsc(LocalDate start, LocalDate end, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific <code>endedAt</code> date ordered by score (descendent) and title (ascending)
     *
     * @param launchedAt {@link LocalDate}
     * @param pageable {@link LocalDate}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByEndedAtOrderByScoreDescTitleAsc(LocalDate launchedAt, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific {@link SourceType} ordered by score (descendent) and title (ascending)
     *
     * @param source {@link SourceType}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesBySourceOrderByScoreDescTitleAsc(SourceType source, Pageable pageable);

    /**
     * Retrieve all paginated anime of a specific or a set of {@link Genre} ordered by score (descendent) and title (ascending)
     *
     * @param genres {@link Genre}
     * @param pageable {@link Pageable}
     * @return {@link AnimeEntity}
     */
    Page<AnimeEntity> findAnimeEntitiesByGenresOrderByScoreDescTitleAsc(List<Genre> genres, Pageable pageable);

}
