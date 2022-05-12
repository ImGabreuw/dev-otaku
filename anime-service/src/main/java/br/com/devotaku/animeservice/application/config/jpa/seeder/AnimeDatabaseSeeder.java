package br.com.devotaku.animeservice.application.config.jpa.seeder;

import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.builder.AnimeBuilder;
import br.com.devotaku.animeservice.domain.ports.repositories.AnimeRepository;
import br.com.devotaku.animeservice.shared.generators.IdentifierUtils;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Profile({"test", "dev"})
@Component
@RequiredArgsConstructor
public class AnimeDatabaseSeeder implements CommandLineRunner {

    private final AnimeRepository animeRepository;

    @Override
    public void run(String... args) {
        var limit = PageInfo.createDefault().pageSize();

        createDummiesAnime(limit).forEach(animeRepository::save);

        log.info("populating the database with %s dummy anime".formatted(limit));
    }

    private List<Anime> createDummiesAnime(long limit) {
        var identifiers = IdentifierUtils.getInstance().generateIdentifierSequence(1, limit);

        return identifiers
                .stream()
                .map(id -> AnimeBuilder.builder()
                        .id(id)
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
                        .build()
                )
                .collect(Collectors.toList());
    }

}
