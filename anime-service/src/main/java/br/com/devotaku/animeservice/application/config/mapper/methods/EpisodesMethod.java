package br.com.devotaku.animeservice.application.config.mapper.methods;

import br.com.devotaku.animeservice.application.config.mapper.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapper.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapper.annotations.episodes.EpisodesMapper;
import br.com.devotaku.animeservice.domain.entities.value.objects.Episodes;
import org.springframework.stereotype.Component;

@EpisodesMapper
@Component
public class EpisodesMethod {

    @ToApp
    public Integer mapToApp(Episodes episodes) {
        return episodes.value();
    }

    @ToDomain
    public Episodes mapToDomain(Integer episodes) {
        return new Episodes(episodes);
    }

}
