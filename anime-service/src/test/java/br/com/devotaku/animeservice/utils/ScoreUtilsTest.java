package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.shared.generators.ScoreUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreUtilsTest {

    private static ScoreUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = ScoreUtils.getInstance();
    }

    @DisplayName("Should generate Score value")
    @Test
    void shouldGenerateScoreValue() {
        var value = underTest.generateScoreValue();

        assertThat(value).isBetween(0.00, 10.00);
    }

    @DisplayName("Should generate Score")
    @Test
    void shouldGenerateScore() {
        var score = underTest.generateScore();

        assertThat(score.value()).isBetween(0.00, 10.00);
    }

}