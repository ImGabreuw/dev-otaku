package br.com.devotaku.animeservice.application.config.mapstruct.methods;

import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.producer.ProducerMapper;
import br.com.devotaku.animeservice.domain.entities.value.objects.Producer;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@ProducerMapper
@Component
public class ProducerMethod {

    @ToApp
    public Set<String> mapToApp(Set<Producer> producers) {
        return producers.stream()
                .map(Producer::value)
                .collect(Collectors.toSet());
    }

    @ToDomain
    public Set<Producer> mapToDomain(Set<String> producers) {
        return producers.stream()
                .map(Producer::new)
                .collect(Collectors.toSet());
    }

}
