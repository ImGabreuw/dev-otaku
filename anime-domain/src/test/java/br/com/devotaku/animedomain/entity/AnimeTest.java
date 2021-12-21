package br.com.devotaku.animedomain.entity;

import br.com.devotaku.animedomain.entity.builder.AnimeBuilder;
import br.com.devotaku.animedomain.entity.enums.Genre;
import br.com.devotaku.animedomain.entity.enums.SourceType;
import br.com.devotaku.animedomain.entity.enums.Status;
import br.com.devotaku.animedomain.entity.value.object.AlternativeName;
import br.com.devotaku.animedomain.entity.value.object.Producer;
import br.com.devotaku.animedomain.entity.value.object.Studio;
import br.com.devotaku.shared.date.DateParser;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static br.com.devotaku.animedomain.entity.enums.Genre.ACTION;
import static br.com.devotaku.animedomain.entity.enums.Genre.SUPERNATURAL;
import static br.com.devotaku.animedomain.entity.enums.SourceType.MANGA;
import static br.com.devotaku.animedomain.entity.enums.Status.FINISHED;
import static org.assertj.core.api.Assertions.assertThat;

class AnimeTest {

    @Test
    void shouldCreateAnime() {
        // given
        String title = "Jujutsu Kaisen";
        AlternativeName[] alternativeNames = {
                new AlternativeName("呪術廻戦"),
                new AlternativeName("Sorcery Fight")
        };
        String description = "Jujutsu Kaisen Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa...";
        double score = 8.72;
        int episodes = 24;
        Status status = FINISHED;
        LocalDate launchedAt = DateParser.parse("2020-10-02");
        LocalDate endedAt = DateParser.parse("2021-03-27");
        Producer[] producers = {
                new Producer("Mainichi Broadcasting System"),
                new Producer("TOHO animation"),
                new Producer("Shueisha"),
                new Producer("dugout"),
                new Producer("Sumzap")
        };
        Studio[] studios = new Studio[]{new Studio("MAPPA")};
        SourceType source = MANGA;
        Genre[] genres = {ACTION, SUPERNATURAL};

        // when
        Anime underTestAnime = AnimeBuilder.builder()
                .title(title)
                .alternativeNames(alternativeNames)
                .description(description)
                .score(score)
                .episodes(episodes)
                .status(status)
                .launchedAt(launchedAt)
                .endedAt(endedAt)
                .producers(producers)
                .studios(studios)
                .source(source)
                .genres(genres)
                .build();

        // then
        assertThat(underTestAnime.getTitle()).isEqualTo(title);
        assertThat(underTestAnime.getAlternativeNames()).contains(alternativeNames);
        assertThat(underTestAnime.getDescription()).isEqualTo(description);
        assertThat(underTestAnime.getScore()).isEqualTo(score);
        assertThat(underTestAnime.getEpisodes()).isEqualTo(episodes);
        assertThat(underTestAnime.getLaunchedAt()).isEqualTo(launchedAt);
        assertThat(underTestAnime.getEndedAt()).isEqualTo(endedAt);
        assertThat(underTestAnime.getProducers()).contains(producers);
        assertThat(underTestAnime.getStudios()).contains(studios);
        assertThat(underTestAnime.getStatus()).isEqualTo(status);
        assertThat(underTestAnime.getGenres()).contains(genres);
    }

}