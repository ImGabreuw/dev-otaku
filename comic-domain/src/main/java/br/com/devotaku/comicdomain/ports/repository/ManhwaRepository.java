package br.com.devotaku.comicdomain.ports.repository;

import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;

import java.util.List;
import java.util.Optional;

public interface ManhwaRepository {

    Optional<Manhwa> findById(Identifier identifier);

    List<Manhwa> findAll(PageInfo pageInfo);

    Optional<Manhwa> findByTitleOrAlternativesName(String manhwaName);

    List<Manhwa> fetchTopUseCase(PageInfo pageInfo);

    List<Manhwa> findAllByFinished(PageInfo pageInfo);

    List<Manhwa> findAllByPublishing(PageInfo pageInfo);

}
