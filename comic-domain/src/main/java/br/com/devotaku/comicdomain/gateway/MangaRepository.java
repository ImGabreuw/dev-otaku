package br.com.devotaku.comicdomain.gateway;

import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.comicdomain.entity.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;

import java.util.List;
import java.util.Optional;

public interface MangaRepository {

    Optional<Manga> findById(Identifier identifier);

    List<Manga> findAll(PageInfo pageInfo);

    Optional<Manga> findByTitleOrAlternativesName(String mangaName);

    List<Manga> fetchTopUseCase(PageInfo pageInfo);

    List<Manga> findAllByFinished(PageInfo pageInfo);

}
