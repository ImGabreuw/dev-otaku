package br.com.devotaku.animeservice.application.config.mapper.methods;

import br.com.devotaku.animeservice.application.config.mapper.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapper.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapper.annotations.identifier.IdentifierMapper;
import br.com.devotaku.animeservice.domain.entities.value.objects.Identifier;
import org.springframework.stereotype.Component;

@IdentifierMapper
@Component
public class IdentifierMethod {

    @ToApp
    public Long mapToApp(Identifier id) {
        return id.value();
    }

    @ToDomain
    public Identifier mapToDomain(Long id) {
        return new Identifier(id);
    }

}
