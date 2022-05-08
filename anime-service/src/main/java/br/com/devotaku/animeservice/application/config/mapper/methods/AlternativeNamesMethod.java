package br.com.devotaku.animeservice.application.config.mapper.methods;

import br.com.devotaku.animeservice.application.config.mapper.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapper.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapper.annotations.alternative.names.AlternativeNamesMapper;
import br.com.devotaku.animeservice.domain.entities.value.objects.AlternativeName;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@AlternativeNamesMapper
@Component
public class AlternativeNamesMethod {

    @ToApp
    public Set<String> mapToApp(Set<AlternativeName> alternativeNames) {
        return alternativeNames.stream()
                .map(AlternativeName::value)
                .collect(Collectors.toSet());
    }

    @ToDomain
    public Set<AlternativeName> mapToDomain(Set<String> alternativeNames) {
        return alternativeNames.stream()
                .map(AlternativeName::new)
                .collect(Collectors.toSet());
    }

}
