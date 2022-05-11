package br.com.devotaku.animeservice.domain.entities.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.devotaku.animeservice.domain.entities.enums.Season.WINTER;
import static java.time.Month.*;
import static org.assertj.core.api.Assertions.assertThat;

class SeasonTest {

    @DisplayName("Should get months from winter season")
    @Test
    void shouldGetMonthsFromWinterSeason() {
        var underTest = WINTER.getSeasonMonths();

        assertThat(underTest).containsExactly(JANUARY, FEBRUARY, MARCH);
    }

    @DisplayName("Should get value of months from winter season")
    @Test
    void shouldGetValueOfMonthsFromWinterSeason() {
        var underTest = WINTER.getValueOfSeasonMonths();

        assertThat(underTest).containsExactly(JANUARY.getValue(), FEBRUARY.getValue(), MARCH.getValue());
    }

}