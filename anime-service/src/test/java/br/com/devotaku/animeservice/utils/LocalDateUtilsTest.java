package br.com.devotaku.animeservice.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static br.com.devotaku.animeservice.utils.LocalDateUtils.DATE_RANGE_DEFAULT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class LocalDateUtilsTest {

    private static LocalDateUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = LocalDateUtils.getInstance();
    }

    @DisplayName("Should generate LocalDate")
    @Test
    void shouldGenerateLocalDate() {
        var to = LocalDate.now();
        var from = to.minusYears(DATE_RANGE_DEFAULT_VALUE);

        var localDate = underTest.generateLocalDate(from, to);

        assertThat(localDate).isBetween(from, to);
    }

    @DisplayName("Should generate LaunchedAt")
    @Test
    void shouldGenerateLaunchedAt() {
        var to = LocalDate.now();
        var from = to.minusYears(DATE_RANGE_DEFAULT_VALUE);

        var launchedAt = underTest.generateLaunchedAt();

        assertThat(launchedAt).isBetween(from, to);
    }

    @DisplayName("Should generate EndedAt")
    @Test
    void shouldGenerateEndedAt() {
        var launchedAt = underTest.generateLaunchedAt();
        var to = LocalDate.now();

        underTest.generateEndedAt(launchedAt)
                .ifPresent(endedAt -> assertThat(endedAt).isBetween(launchedAt, to));
    }

}