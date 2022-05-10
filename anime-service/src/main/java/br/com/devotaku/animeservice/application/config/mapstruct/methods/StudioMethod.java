package br.com.devotaku.animeservice.application.config.mapstruct.methods;

import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.studio.StudioMapper;
import br.com.devotaku.animeservice.domain.entities.value.objects.Studio;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@StudioMapper
@Component
public class StudioMethod {

    @ToApp
    public Set<String> mapToApp(Set<Studio> studios) {
        return studios.stream()
                .map(Studio::value)
                .collect(Collectors.toSet());
    }

    @ToDomain
    public Set<Studio> mapToDomain(Set<String> studios) {
        return studios.stream()
                .map(Studio::new)
                .collect(Collectors.toSet());
    }

}
