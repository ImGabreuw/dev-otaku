package br.com.devotaku.animeservice.application.dataprovider.jpa;

import br.com.devotaku.animeservice.application.dataprovider.entities.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeJpaRepository extends JpaRepository<AnimeEntity, Long> {
}
