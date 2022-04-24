package br.com.devotaku.animeservice.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Date;

public class LocalDateUtils {

    public static final long DATE_RANGE_DEFAULT_VALUE = 10; // 10 years

    private static LocalDateUtils instance;
    private final Faker faker;

    private LocalDateUtils() {
        this.faker = Faker.instance();
    }

    public static LocalDateUtils getInstance() {
        if (instance == null) {
            instance = new LocalDateUtils();
        }

        return instance;
    }

    public LocalDate generateLaunchedAt() {
        var maximum = LocalDate.now();
        var minimum = maximum.minusYears(DATE_RANGE_DEFAULT_VALUE);

        return LocalDate.ofEpochDay(
                faker.date().between(new Date(minimum.toEpochDay()), new Date(maximum.toEpochDay())).getTime()
        );
    }

}
