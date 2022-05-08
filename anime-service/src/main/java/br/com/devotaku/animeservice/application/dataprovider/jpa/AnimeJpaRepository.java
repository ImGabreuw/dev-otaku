package br.com.devotaku.animeservice.application.dataprovider.jpa;

import br.com.devotaku.animeservice.application.dataprovider.entities.AnimeEntity;
import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimeJpaRepository extends JpaRepository<AnimeEntity, Long> {

    Optional<AnimeEntity> findByTitleOrAlternativeNames(String animeName);

    List<AnimeEntity> findAllByProducers(String producerName);

    List<AnimeEntity> findAllByStudios(String studioName);

    List<AnimeEntity> findTopByScore(Pageable pageable);

    List<AnimeEntity> findAllByStatus_Finished(Pageable pageable);

    List<AnimeEntity> findAllByStatus_Publishing(Pageable pageable);

    List<AnimeEntity> findAllByLaunchedAtToday(Pageable pageable);

    List<AnimeEntity> findAllByEndedAtToday(Pageable pageable);

    List<AnimeEntity> findAllBySourceTypeAsManga(Pageable pageable);

    List<AnimeEntity> findAllBySourceTypeAsManhwa(Pageable pageable);

    List<AnimeEntity> findAllBySourceTypeAsWebtoon(Pageable pageable);

    List<AnimeEntity> findAllByGenre(Genre genre, Pageable pageable);

}
