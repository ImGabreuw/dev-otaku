package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.shared.generators.TitleUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TitleUtilsTest {

    private static TitleUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = TitleUtils.getInstance();
    }

    @DisplayName("Should generate Title value")
    @Test
    void shouldGenerateTitleValue() {
        var value = underTest.generateTitleValue();

        assertThat(value).isNotBlank();
    }

    @DisplayName("Should generate Title")
    @Test
    void shouldGenerateTitle() {
        var title = underTest.generateTitle();

        assertThat(title.value()).isNotBlank();
    }

}