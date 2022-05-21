package br.com.devotaku.animeservice.application.config.mapstruct.methods;

import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.genre.GenreMapper;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@GenreMapper
@Component
public class GenreMethod {

    @ToApp
    public Set<String> mapToApp(Set<Genre> genres) {
        return genres
                .stream()
                .map(Genre::toString)
                .collect(Collectors.toSet());
    }

    @ToDomain
    public Set<Genre> mapToDomain(Set<String> genres) {
        return genres
                .stream()
                .map(Genre::valueOf)
                .collect(Collectors.toSet());
    }

}
