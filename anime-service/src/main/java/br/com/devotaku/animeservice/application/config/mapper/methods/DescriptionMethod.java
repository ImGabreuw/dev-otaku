package br.com.devotaku.animeservice.application.config.mapper.methods;

import br.com.devotaku.animeservice.application.config.mapper.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapper.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapper.annotations.description.DescriptionMapper;
import br.com.devotaku.animeservice.domain.entities.value.objects.Description;
import org.springframework.stereotype.Component;

@DescriptionMapper
@Component
public class DescriptionMethod {

    @ToApp
    public String mapToApp(Description description) {
        return description.value();
    }

    @ToDomain
    public Description mapToDomain(String description) {
        return new Description(description);
    }

}
