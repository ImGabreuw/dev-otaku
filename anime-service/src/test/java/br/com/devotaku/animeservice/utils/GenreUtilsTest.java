package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.shared.generators.GenreUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenreUtilsTest {

    private static GenreUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = GenreUtils.getInstance();
    }

    @DisplayName("Should generate a list with 3 Genre")
    @Test
    void shouldGenerateAListWith3Genre() {
        var limit = 3;
        var genres = underTest.generateGenres(limit);

        assertThat(genres).hasSize(limit);
    }

    @DisplayName("Should generate a list of Genre")
    @Test
    void shouldGenerateAListOfGenre() {
        var genres = underTest.generateGenres();

        assertThat(genres).hasSize(GenreUtils.LIMIT_DEFAULT_VALUE);
    }

}