package br.com.devotaku.animeservice.domain.ports.repositories;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.entities.enums.Season;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AnimeRepository {

    List<Anime> findAll(PageInfo pageInfo);

    Optional<Anime> findById(Long id);

    List<Anime> findByTitleOrAlternativeNames(String animeName, PageInfo pageInfo);

    List<Anime> findByProducer(String producerName, PageInfo pageInfo);

    List<Anime> findByStudio(String studioName, PageInfo pageInfo);

    List<Anime> fetchTop(PageInfo pageInfo);

    List<Anime> findByStatusFinished(PageInfo pageInfo);

    List<Anime> findByStatusPublishing(PageInfo pageInfo);

    List<Anime> findByLaunchedAtToday(PageInfo pageInfo);

    List<Anime> findBySeason(Season season, PageInfo pageInfo);

    List<Anime> findByEndedAtToday(PageInfo pageInfo);

    List<Anime> findBySourceTypeManga(PageInfo pageInfo);

    List<Anime> findBySourceTypeManhwa(PageInfo pageInfo);

    List<Anime> findBySourceTypeWebtoon(PageInfo pageInfo);

    List<Anime> findByGenres(Set<Genre> genres, PageInfo pageInfo);

    Anime save(Anime anime);

    void delete(Anime anime);

    void deleteById(Long id);

    boolean existsById(Long id);

    long count();

}
