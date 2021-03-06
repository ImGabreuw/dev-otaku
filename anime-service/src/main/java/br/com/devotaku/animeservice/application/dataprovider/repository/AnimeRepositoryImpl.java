package br.com.devotaku.animeservice.application.dataprovider.repository;

import br.com.devotaku.animeservice.application.config.mapstruct.AnimeMapper;
import br.com.devotaku.animeservice.application.dataprovider.entities.AnimeEntity;
import br.com.devotaku.animeservice.application.dataprovider.jpa.AnimeJpaRepository;
import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.entities.enums.Season;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
        var page = pageInfo.toSortedPageRequest();

        var titleSearch = animeJpaRepository
                .findByTitleIsLikeIgnoreCase(animeName, page);
        var alternativeNamesSearch = animeJpaRepository
                .findDistinctByAlternativeNamesIsLikeIgnoreCase(animeName, page);

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
                .findByProducersIsLikeIgnoreCase(producerName, page);

        return producerSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByStudio(String studioName, PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var studioSearch = animeJpaRepository
                .findByStudiosIsLikeIgnoreCase(studioName, page);

        return studioSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> fetchTop(PageInfo pageInfo) {
        var page = pageInfo.toSortedPageRequest();

        var searchTop = animeJpaRepository
                .findAll(page);

        return searchTop
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByStatusFinished(PageInfo pageInfo) {
        var page = pageInfo.toSortedPageRequest();

        var statusFinishedSearch = animeJpaRepository
                .findByStatusIsLike(FINISHED, page);

        return statusFinishedSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByStatusPublishing(PageInfo pageInfo) {
        var page = pageInfo.toSortedPageRequest();

        var statusPublishingSearch = animeJpaRepository
                .findByStatusIsLike(PUBLISHING, page);

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
                .findByLaunchedAtEquals(today, page);

        return launchedAtTodaySearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findBySeason(Season season, PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        List<AnimeEntity> intersection = new ArrayList<>();

        for (int month : season.getValueOfSeasonMonths()) {
            var monthSearch = animeJpaRepository.findByLaunchedAtMonthValue(month, page);

            intersection.addAll(monthSearch.toList());
        }

        return intersection
                .stream()
                .distinct()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByEndedAtToday(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();
        var today = LocalDate.now();

        var endedAtTodaySearch = animeJpaRepository
                .findByEndedAtEquals(today, page);

        return endedAtTodaySearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findBySourceTypeManga(PageInfo pageInfo) {
        var page = pageInfo.toPageRequest();

        var sourceTypeMangaSearch = animeJpaRepository
                .findBySourceEquals(MANGA, page);

        return sourceTypeMangaSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findBySourceTypeManhwa(PageInfo pageInfo) {
        var page = pageInfo.toSortedPageRequest();

        var sourceTypeManhwaSearch = animeJpaRepository
                .findBySourceEquals(MANHWA, page);

        return sourceTypeManhwaSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findBySourceTypeWebtoon(PageInfo pageInfo) {
        var page = pageInfo.toSortedPageRequest();

        var sourceTypeWebtoonSearch = animeJpaRepository
                .findBySourceEquals(WEBTOON, page);

        return sourceTypeWebtoonSearch
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findByGenres(Set<Genre> genres, PageInfo pageInfo) {
        var page = pageInfo.toSortedPageRequest();

        var genreNames = genres
                .stream()
                .map(Genre::toString)
                .collect(Collectors.toSet());

        var genresSearch = animeJpaRepository
                .findAllByGenresIn(genreNames, page);

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

    @Override
    public long count() {
        return animeJpaRepository.count();
    }

}
