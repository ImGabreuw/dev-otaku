package br.com.devotaku.animedomain.ports.repository;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.entity.value.object.Identifier;
import br.com.devotaku.shared.pagination.PageInfo;

import java.util.List;
import java.util.Optional;

public interface AnimeRepository {

    Optional<Anime> findById(Identifier id);

    List<Anime> findAll(PageInfo pageInfo);

    Optional<Anime> findByTitleOrAlternativesName(String animeName);

    List<Anime> fetchTop(PageInfo pageInfo);

    List<Anime> findAllByFinished(PageInfo pageInfo);

    List<Anime> findAllByPublishing(PageInfo pageInfo);

}
