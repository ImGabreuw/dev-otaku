package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.value.objects.Episodes;
import com.github.javafaker.Faker;

public class EpisodesUtils {

    public static final int EPISODES_DEFAULT_VALUE = 10;

    private static EpisodesUtils instance;

    private final Faker faker;

    private EpisodesUtils() {
        this.faker = Faker.instance();
    }

    public static EpisodesUtils getInstance() {
        if (instance == null) {
            instance = new EpisodesUtils();
        }

        return instance;
    }

    public int generateEpisodesValue(int maximum) {
        return faker.number().numberBetween(1, maximum);
    }

    public int generateEpisodesValue() {
        return faker.number().numberBetween(1, EPISODES_DEFAULT_VALUE);
    }

    public Episodes generateEpisodes(int maximum) {
        return new Episodes(generateEpisodesValue(maximum));
    }

    public Episodes generateEpisodes() {
        return new Episodes(generateEpisodesValue());
    }

}
