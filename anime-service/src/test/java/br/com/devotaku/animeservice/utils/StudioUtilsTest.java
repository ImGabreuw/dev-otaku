package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.shared.generators.StudioUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.devotaku.animeservice.shared.generators.StudioUtils.LIMIT_DEFAULT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class StudioUtilsTest {

    private static StudioUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = StudioUtils.getInstance();
    }

    @DisplayName("Should generate Studio value")
    @Test
    void shouldGenerateStudioValue() {
        var value = underTest.generateStudioValue();

        assertThat(value).isNotBlank();
    }

    @DisplayName("Should generate Studio")
    @Test
    void shouldGenerateStudio() {
        var studio = underTest.generateStudio();

        assertThat(studio.value()).isNotBlank();
    }

    @DisplayName("Should generate a list with 3 Studio")
    @Test
    void shouldGenerateAListWith3Studio() {
        var limit = 3;
        var studios = underTest.generateStudioSequence(limit);

        assertThat(studios)
                .hasSize(limit)
                .allMatch(StudioUtils::isNotBlank);
    }

    @DisplayName("Should generate a list of Studio")
    @Test
    void shouldGenerateAListOfStudio() {
        var studios = underTest.generateStudioSequence();

        assertThat(studios)
                .hasSize(LIMIT_DEFAULT_VALUE)
                .allMatch(StudioUtils::isNotBlank);
    }

}