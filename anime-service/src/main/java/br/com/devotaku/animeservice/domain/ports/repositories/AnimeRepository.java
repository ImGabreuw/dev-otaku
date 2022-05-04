package br.com.devotaku.animeservice.domain.ports.repositories;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.shared.page.PageInfo;

import java.util.List;
import java.util.Optional;

public interface AnimeRepository {

    List<Anime> findAll(PageInfo pageInfo);

    Optional<Anime> findById(Long id);

    Optional<Anime> findByTitleOrAlternativeName(String animeName);

    List<Anime> findAllByProducer(String producerName);

    List<Anime> findAllByStudio(String studioName);

    List<Anime> fetchTop(PageInfo pageInfo);

    default List<Anime> fetchTop() {
        return fetchTop(PageInfo.createDefault());
    }

    List<Anime> findAllByFinished(PageInfo pageInfo);

    default List<Anime> findAllByFinished() {
        return findAllByFinished(PageInfo.createDefault());
    }

    List<Anime> findAllByPublishing(PageInfo pageInfo);

    default List<Anime> findAllByPublishing() {
        return findAllByPublishing(PageInfo.createDefault());
    }

    List<Anime> findAllByLaunchedAtToday(PageInfo pageInfo);

    default List<Anime> findAllByLaunchedAtToday() {
        return findAllByLaunchedAtToday(PageInfo.createDefault());
    }

    List<Anime> findAllByEndedAtToday(PageInfo pageInfo);

    default List<Anime> findAllByEndedAtToday() {
        return findAllByEndedAtToday(PageInfo.createDefault());
    }

    List<Anime> findAllBySourceTypeAsManga(PageInfo pageInfo);

    default List<Anime> findAllBySourceTypeAsManga() {
        return findAllBySourceTypeAsManga(PageInfo.createDefault());
    }

    List<Anime> findAllBySourceTypeAsManhwa(PageInfo pageInfo);

    default List<Anime> findAllBySourceTypeAsManhwa() {
        return findAllBySourceTypeAsManhwa(PageInfo.createDefault());
    }

    List<Anime> findAllBySourceTypeAsWebtoon(PageInfo pageInfo);

    default List<Anime> findAllBySourceTypeAsWebtoon() {
        return findAllBySourceTypeAsWebtoon(PageInfo.createDefault());
    }

    List<Anime> findAllByGenre(Genre genre, PageInfo pageInfo);

    default List<Anime> findAllByGenre(Genre genre) {
        return findAllByGenre(genre, PageInfo.createDefault());
    }

    Anime save(Anime anime);

    void delete(Anime anime);

    void deleteById(Long id);

    boolean existsById(Long id);

}
