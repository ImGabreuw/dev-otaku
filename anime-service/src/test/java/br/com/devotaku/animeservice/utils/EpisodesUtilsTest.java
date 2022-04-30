package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.shared.generators.EpisodesUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.devotaku.animeservice.shared.generators.EpisodesUtils.EPISODES_DEFAULT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class EpisodesUtilsTest {

    private static EpisodesUtils episodesUtils;

    @BeforeAll
    static void beforeAll() {
        episodesUtils = EpisodesUtils.getInstance();
    }

    @DisplayName("Should generate Episodes value with maximum of 20")
    @Test
    void shouldGenerateEpisodesValueWithMaximumOf20() {
        var maximum = 20;
        var value = episodesUtils.generateEpisodesValue(maximum);

        assertThat(value).isBetween(1, maximum);
    }

    @DisplayName("Should generate Episodes value with maximum default value")
    @Test
    void shouldGenerateEpisodesValueWithMaximumDefaultValue() {
        var value = episodesUtils.generateEpisodesValue();

        assertThat(value).isBetween(1, EPISODES_DEFAULT_VALUE);
    }

    @DisplayName("Should generate Episodes with maximum of 20")
    @Test
    void shouldGenerateEpisodesWithMaximumOf20() {
        var maximum = 20;
        var episodes = episodesUtils.generateEpisodes(maximum);

        assertThat(episodes.value()).isBetween(1, maximum);
    }

    @DisplayName("Should generate Episodes with maximum default value")
    @Test
    void shouldGenerateEpisodesWithMaximumDefaultValue() {
        var episodes = episodesUtils.generateEpisodes();

        assertThat(episodes.value()).isBetween(1, EPISODES_DEFAULT_VALUE);
    }

}