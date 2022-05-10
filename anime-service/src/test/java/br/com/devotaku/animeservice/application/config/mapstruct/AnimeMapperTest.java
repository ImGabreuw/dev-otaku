package br.com.devotaku.animeservice.application.config.mapstruct;

import br.com.devotaku.animeservice.domain.entities.builder.AnimeBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnimeMapperTest {

    @Autowired
    private AnimeMapper underTest;

    @DisplayName("Should map Domain entity to App entity")
    @Test
    void shouldMapDomainEntityToAppEntity() {
        var anime = AnimeBuilder.builder()
                .id()
                .title()
                .alternativeNames()
                .description()
                .score()
                .episodes()
                .status()
                .launchedAt()
                .endedAt()
                .producers()
                .studios()
                .source()
                .genres()
                .build();

        var animeEntity = underTest.mapToApp(anime);

        System.out.println(animeEntity);
    }
}