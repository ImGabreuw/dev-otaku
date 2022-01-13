package br.com.devotaku.animedomain.ports.repository;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.animedomain.entity.builder.AnimeBuilder;
import br.com.devotaku.animedomain.entity.enums.Status;
import br.com.devotaku.animedomain.entity.value.object.AlternativeName;
import br.com.devotaku.animedomain.entity.value.object.Identifier;
import br.com.devotaku.animedomain.entity.value.object.Producer;
import br.com.devotaku.animedomain.entity.value.object.Studio;
import br.com.devotaku.shared.date.DateParser;
import br.com.devotaku.shared.pagination.PageInfo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static br.com.devotaku.animedomain.entity.enums.Genre.ACTION;
import static br.com.devotaku.animedomain.entity.enums.Genre.SUPERNATURAL;
import static br.com.devotaku.animedomain.entity.enums.SourceType.MANGA;
import static br.com.devotaku.animedomain.entity.enums.Status.FINISHED;
import static br.com.devotaku.animedomain.entity.enums.Status.PUBLISHING;

public class AnimeRepositoryMock implements AnimeRepository {

    private final Anime baseAnime = AnimeBuilder.builder()
            .id(new Identifier(1L))
            .title("Jujutsu Kaisen")
            .alternativeNames(new AlternativeName("呪術廻戦"), new AlternativeName("Sorcery Fight"))
            .description("Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...")
            .score(8.72)
            .episodes(24)
            .status(FINISHED)
            .launchedAt(DateParser.parse("2020-10-02"))
            .endedAt(DateParser.parse("2021-03-27"))
            .producers(
                    new Producer("Mainichi Broadcasting System"),
                    new Producer("TOHO animation"),
                    new Producer("Shueisha"),
                    new Producer("dugout"),
                    new Producer("Sumzap")
            )
            .studios(new Studio("MAPPA"))
            .source(MANGA)
            .genres(ACTION, SUPERNATURAL)
            .build();

    @Override
    public Optional<Anime> findById(Identifier id) {
        if (!baseAnime.getId().equals(id)) {
            return Optional.empty();
        }

        return Optional.of(baseAnime);
    }

    @Override
    public List<Anime> findAll(PageInfo pageInfo) {
        return Stream.iterate(baseAnime, Identifier::increment)
                .limit(pageInfo.pageSize())
                .toList();
    }

    @Override
    public Optional<Anime> findByTitleOrAlternativesName(String animeName) {
        if (!baseAnime.hasTitleOrAlternativeNamesEqualsTo(animeName)) {
            return Optional.empty();
        }

        return Optional.of(baseAnime);
    }

    @Override
    public List<Anime> fetchTop(PageInfo pageInfo) {
        int limit = (pageInfo.pageNumber() + 1) * pageInfo.pageSize();

        List<Anime> mangas = Anime.generateRandomScore(baseAnime, limit);
        mangas.sort(Comparator.comparing(Anime::getScore).reversed());

        return mangas.subList(pageInfo.lastElementPosition() - 1, pageInfo.firstElementPosition());
    }

    @Override
    public List<Anime> findAllByFinished(PageInfo pageInfo) {
        return Stream.generate(baseAnime::clone)
                .limit(pageInfo.pageSize())
                .toList();
    }

    @Override
    public List<Anime> findAllByPublishing(PageInfo pageInfo) {
        return Stream.generate(() -> {
                    var clone = baseAnime.clone();
                    clone.setStatus(PUBLISHING);

                    return clone;
                })
                .limit(pageInfo.pageSize())
                .toList();
    }
}