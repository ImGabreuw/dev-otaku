package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.value.objects.Score;
import com.github.javafaker.Faker;

public class ScoreUtils {

    private static ScoreUtils instance;

    private final Faker faker;

    private ScoreUtils() {
        this.faker = Faker.instance();
    }

    public static ScoreUtils getInstance() {
        if (instance == null) {
            instance = new ScoreUtils();
        }

        return instance;
    }

    public double generateScoreValue() {
        return faker.number().randomDouble(2, 0, 10);
    }

    public Score generateScore() {
        return new Score(generateScoreValue());
    }

}
