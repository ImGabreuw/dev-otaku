package br.com.devotaku.animeservice.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

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

    public LocalDate generateLocalDate(LocalDate from, LocalDate to) {
        var date = faker.date().between(new Date(from.toEpochDay()), new Date(to.toEpochDay()));

        return LocalDate.ofEpochDay(date.getTime());
    }

    public LocalDate generateLaunchedAt() {
        var to = LocalDate.now();
        var from = to.minusYears(DATE_RANGE_DEFAULT_VALUE);

        return generateLocalDate(from, to);
    }

    public Optional<LocalDate> generateEndedAt(LocalDate launchedAt) {
        LocalDate endedAt = null;
        Boolean isEnded = faker.random().nextBoolean();

        if (isEnded) {
            endedAt = generateLocalDate(launchedAt, LocalDate.now());
        }

        return Optional.ofNullable(endedAt);
    }

}
