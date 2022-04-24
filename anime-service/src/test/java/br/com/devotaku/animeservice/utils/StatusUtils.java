package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.domain.entities.enums.Status;
import com.github.javafaker.Faker;

public class StatusUtils {

    private static StatusUtils instance;

    private final Faker faker;

    private StatusUtils() {
        this.faker = Faker.instance();
    }

    public static StatusUtils getInstance() {
        if (instance == null) {
            instance = new StatusUtils();
        }

        return instance;
    }

    public Status generateStatus() {
        var status = Status.values();

        return status[faker.number().numberBetween(0, status.length - 1)];
    }

}
