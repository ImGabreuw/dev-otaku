package br.com.devotaku.animeservice.application.config.mapstruct.methods;

import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapstruct.annotations.score.ScoreMapper;
import br.com.devotaku.animeservice.domain.entities.value.objects.Score;
import org.springframework.stereotype.Component;

@ScoreMapper
@Component
public class ScoreMethod {

    @ToApp
    public Double mapToApp(Score score) {
        return score.value();
    }

    @ToDomain
    public Score mapToDomain(Double score) {
        return new Score(score);
    }

}
