package br.com.devotaku.animeservice.application.config.mapstruct.methods;

import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.title.TitleMapper;
import br.com.devotaku.animeservice.domain.entities.value.objects.Title;
import org.springframework.stereotype.Component;

@TitleMapper
@Component
public class TitleMethod {

    @ToApp
    public String mapToApp(Title title) {
        return title.value();
    }

    @ToDomain
    public Title mapToDomain(String title) {
        return new Title(title);
    }

}
