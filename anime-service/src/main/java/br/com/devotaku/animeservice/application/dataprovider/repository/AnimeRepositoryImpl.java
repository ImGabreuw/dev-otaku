package br.com.devotaku.animeservice.application.dataprovider.repository;

import br.com.devotaku.animeservice.application.config.mapper.AnimeMapper;
import br.com.devotaku.animeservice.application.dataprovider.jpa.AnimeJpaRepository;
import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class AnimeRepositoryImpl implements AnimeRepository {

    private final AnimeJpaRepository animeJpaRepository;
    private final AnimeMapper animeMapper;

    @Override
    public List<Anime> findAll(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAll(request)
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
    public Optional<Anime> findByTitleOrAlternativeNames(String animeName) {
        return animeJpaRepository
                .findByTitleOrAlternativeNames(animeName)
                .map(animeMapper::mapToDomain);
    }

    @Override
    public List<Anime> findAllByProducers(String producerName) {
        return animeJpaRepository
                .findAllByProducers(producerName)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllByStudios(String studioName) {
        return animeJpaRepository
                .findAllByStudios(studioName)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> fetchTop(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findTopByScore(request)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllByFinished(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAllByStatus_Finished(request)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllByPublishing(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAllByStatus_Publishing(request)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllByLaunchedAtToday(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAllByLaunchedAtToday(request)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllByEndedAtToday(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAllByEndedAtToday(request)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllBySourceTypeAsManga(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAllBySourceTypeAsManga(request)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllBySourceTypeAsManhwa(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAllBySourceTypeAsManhwa(request)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllBySourceTypeAsWebtoon(PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAllBySourceTypeAsWebtoon(request)
                .stream()
                .map(animeMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Anime> findAllByGenre(Genre genre, PageInfo pageInfo) {
        var request = PageRequest.of(pageInfo.pageNumber(), pageInfo.pageSize());

        return animeJpaRepository
                .findAllByGenre(genre, request)
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
