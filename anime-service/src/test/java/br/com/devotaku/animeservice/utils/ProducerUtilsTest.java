package br.com.devotaku.animeservice.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.devotaku.animeservice.utils.ProducerUtils.LIMIT_DEFAULT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class ProducerUtilsTest {

    private static ProducerUtils underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = ProducerUtils.getInstance();
    }

    @DisplayName("Should generate Producer value")
    @Test
    void shouldGenerateProducerValue() {
        var value = underTest.generateProducerValue();

        assertThat(value).isNotBlank();
    }

    @DisplayName("Should generate Producer")
    @Test
    void shouldGenerateProducer() {
        var producer = underTest.generateProducer();

        assertThat(producer.value()).isNotBlank();
    }

    @DisplayName("Should generate a list with 3 Producer")
    @Test
    void shouldGenerateAListWith3Producer() {
        var limit = 3;
        var producers = underTest.generateProducerSequence(limit);

        assertThat(producers)
                .hasSize(limit)
                .allMatch(ProducerUtils::isNotBlank);
    }

    @DisplayName("Should generate a list of Producer")
    @Test
    void shouldGenerateAListOfProducer() {
        var producers = underTest.generateProducerSequence();

        assertThat(producers)
                .hasSize(LIMIT_DEFAULT_VALUE)
                .allMatch(ProducerUtils::isNotBlank);
    }

}