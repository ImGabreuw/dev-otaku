package br.com.devotaku.animeservice.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static br.com.devotaku.animeservice.utils.LocalDateUtils.DATE_RANGE_DEFAULT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class LocalDateUtilsTest {

    private static LocalDateUtils localDateUtils;

    @BeforeAll
    static void beforeAll() {
        localDateUtils = LocalDateUtils.getInstance();
    }

    @DisplayName("Should generate LaunchedAt")
    @Test
    void shouldGenerateLaunchedAt() {
        var launchedAt = localDateUtils.generateLaunchedAt();

        var maximum = LocalDate.now();
        var minimum = maximum.minusYears(DATE_RANGE_DEFAULT_VALUE);

        assertThat(launchedAt).isBetween(minimum, maximum);
    }

}