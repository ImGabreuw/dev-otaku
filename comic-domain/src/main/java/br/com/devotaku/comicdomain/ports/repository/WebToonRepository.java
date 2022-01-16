package br.com.devotaku.comicdomain.ports.repository;

import br.com.devotaku.comicdomain.entity.WebToon;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;

import java.util.List;
import java.util.Optional;

public interface WebToonRepository {

    Optional<WebToon> findById(Identifier identifier);

    List<WebToon> findAll(PageInfo pageInfo);

    Optional<WebToon> findByTitleOrAlternativesName(String webToonName);

    List<WebToon> fetchTopUseCase(PageInfo pageInfo);

    List<WebToon> findAllByFinished(PageInfo pageInfo);

    List<WebToon> findAllByPublishing(PageInfo pageInfo);

}