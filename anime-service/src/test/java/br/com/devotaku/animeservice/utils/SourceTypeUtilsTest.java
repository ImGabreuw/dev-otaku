package br.com.devotaku.animeservice.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SourceTypeUtilsTest {

    private static SourceTypeUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = SourceTypeUtils.getInstance();
    }

    @DisplayName("Should generate SourceType")
    @Test
    void shouldGenerateSourceType() {
        var sourceType = underTest.generateSourceType();

        assertThat(sourceType).isNotNull();
    }

}