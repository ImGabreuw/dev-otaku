package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.domain.entities.enums.SourceType;
import com.github.javafaker.Faker;

public class SourceTypeUtils {

    private static SourceTypeUtils instance;

    private final Faker faker;

    private SourceTypeUtils() {
        this.faker = Faker.instance();
    }

    public static SourceTypeUtils getInstance() {
        if (instance == null) {
            instance = new SourceTypeUtils();
        }

        return instance;
    }

    public SourceType generateSourceType() {
        var sourceTypes = SourceType.values();

        return sourceTypes[faker.number().numberBetween(0, sourceTypes.length - 1)];
    }

}
