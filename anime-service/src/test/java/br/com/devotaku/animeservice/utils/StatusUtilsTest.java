package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.shared.generators.StatusUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatusUtilsTest {

    private static StatusUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = StatusUtils.getInstance();
    }

    @DisplayName("Should generate Status")
    @Test
    void shouldGenerateStatus() {
        var status = underTest.generateStatus();

        assertThat(status).isNotNull();
    }

}