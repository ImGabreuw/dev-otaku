package br.com.devotaku.animeservice.application.config.mapstruct.methods;

import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.endedat.EndedAtMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@EndedAtMapper
@Component
public class EndedAtMethod {

    @ToApp
    public LocalDate mapToApp(Optional<LocalDate> endedAt) {
        return endedAt.orElse(null);
    }

}
