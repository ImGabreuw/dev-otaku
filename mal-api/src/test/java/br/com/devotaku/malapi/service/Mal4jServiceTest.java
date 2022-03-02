package br.com.devotaku.malapi.service;

import com.kttdevelopment.mal4j.anime.AnimePreview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Mal4jServiceTest {

    private Mal4jService service;

    @BeforeEach
    void setUp() {
        service = new Mal4jService();
    }

    @Test
    void shouldCreateAnInstanceOfMal4j() {
        // when
        var underTest = service.getApiInstance();

        // then
        assertThat(underTest).isNotNull();
    }

    @Test
    void shouldDoASearchThenReturnAnAnime() {
        // given
        var api = service.getApiInstance();

        // when
        var underTest = api.getAnime()
                        .withQuery("さくら荘のペットな彼女")
                        .withLimit(1)
                        .withOffset(1)
                        .includeNSFW(false)
                        .search();

        // then
        assertThat(underTest).isNotNull();
    }
}