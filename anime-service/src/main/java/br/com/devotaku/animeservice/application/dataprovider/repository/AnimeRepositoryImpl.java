package br.com.devotaku.animeservice.application.dataprovider.repository;

import br.com.devotaku.animeservice.application.config.mapstruct.AnimeMapper;
import br.com.devotaku.animeservice.application.dataprovider.jpa.AnimeJpaRepository;
import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.devotaku.animeservice.domain.entities.enums.SourceType.*;
import static br.com.devotaku.animeservice.domain.entities.enums.Status.FINISHED;
import static br.com.devotaku.animeservice.domain.entities.enums.Status.PUBLISHING;

@RequiredArgsConstructor
@Repository
public class AnimeRepositoryImpl implements AnimeRepository {

    private final AnimeJpaRepository animeJpaRepository;
    private final AnimeMapper animeMapper;

    @Override
    public List<Anime> findAll(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        return animeJpaRepository
                .findAll(page)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Anime> findById(Long id) {
        return animeJpaRepository
                .findById(id)
                .map(animeMapper::mapToDomain);
    }

    @Override
    public List<Anime> findByTitleOrAlternativeNames(String animeName, PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var titleSearch = animeJpaRepository
                .findAnimeEntitiesByTitleIsLikeIgnoreCaseByTitleIsLikeIgnoreCaseOrderByScoreDescTitleAsc(animeName, page);
        var alternativeNamesSearch = animeJpaRepository
                .findAnimeEntitiesByAlternativeNamesContainingIgnoreCaseOrderByScoreDescTitleAsc(animeName, page);

        return Stream.concat(
                        titleSearch.stream(),
                        alternativeNamesSearch.stream()
                )
                .distinct()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());

    }

    @Override
    public List<Anime> findByProducer(String producerName, PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var producerSearch = animeJpaRepository
                .findAnimeEntitiesByProducersContainingIgnoreCaseOrderByScoreDescTitleAsc(producerName, page);

        return producerSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByStudio(String studioName, PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var studioSearch = animeJpaRepository
                .findAnimeEntitiesByStudiosContainingIgnoreCaseOrderByScoreDescTitleAsc(studioName, page);

        return studioSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> fetchTop(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var searchTop = animeJpaRepository
                .findTopByOrderByScoreDesc(page);

        return searchTop
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByStatusFinished(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var statusFinishedSearch = animeJpaRepository
                .findAnimeEntitiesByStatusOrderByScoreDescTitleAsc(FINISHED, page);

        return statusFinishedSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByStatusPublishing(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var statusPublishingSearch = animeJpaRepository
                .findAnimeEntitiesByStatusOrderByScoreDescTitleAsc(PUBLISHING, page);

        return statusPublishingSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByLaunchedAtToday(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();
        var today = LocalDate.now();

        var launchedAtTodaySearch = animeJpaRepository
                .findAnimeEntitiesByLaunchedAtOrderByScoreDescTitleAsc(today, page);

        return launchedAtTodaySearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByEndedAtToday(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();
        var today = LocalDate.now();

        var endedAtTodaySearch = animeJpaRepository
                .findAnimeEntitiesByEndedAtOrderByScoreDescTitleAsc(today, page);

        return endedAtTodaySearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findBySourceTypeManga(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var sourceTypeMangaSearch = animeJpaRepository
                .findAnimeEntitiesBySourceOrderByScoreDescTitleAsc(MANGA, page);

        return sourceTypeMangaSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findBySourceTypeAsManhwa(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var sourceTypeManhwaSearch = animeJpaRepository
                .findAnimeEntitiesBySourceOrderByScoreDescTitleAsc(MANHWA, page);

        return sourceTypeManhwaSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findBySourceTypeAsWebtoon(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var sourceTypeWebtoonSearch = animeJpaRepository
                .findAnimeEntitiesBySourceOrderByScoreDescTitleAsc(WEBTOON, page);

        return sourceTypeWebtoonSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllByGenres(List<Genre> genres, PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var genresSearch = animeJpaRepository
                .findAnimeEntitiesByGenresOrderByScoreDescTitleAsc(genres, page);

        return genresSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Anime save(Anime anime) {
        var animeEntity = animeMapper.mapToApp(anime);

        return animeMapper.mapToDomain(
                animeJpaRepository.save(animeEntity)
        );
    }

    @Override
    public void delete(Anime anime) {
        var animeEntity = animeMapper.mapToApp(anime);

        animeJpaRepository.delete(animeEntity);
    }

    @Override
    public void deleteById(Long id) {
        animeJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return animeJpaRepository.existsById(id);
    }

}
