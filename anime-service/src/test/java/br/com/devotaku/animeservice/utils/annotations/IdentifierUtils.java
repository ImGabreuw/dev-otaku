package br.com.devotaku.animeservice.utils.annotations;

import com.github.javafaker.Faker;

public class IdentifierUtils {

    private final Faker faker;

    private static IdentifierUtils instance;

    private IdentifierUtils() {
        this.faker = Faker.instance();
    }

    public static IdentifierUtils getInstance() {
        if (instance == null) {
            instance = new IdentifierUtils();
        }

        return instance;
    }

    public long generateRandomId() {
        return generateRandomId(50);
    }

    public long generateRandomId(long maximum) {
        return faker.number().numberBetween(1, maximum);
    }

}
