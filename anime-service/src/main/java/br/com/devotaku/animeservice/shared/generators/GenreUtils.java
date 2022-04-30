package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenreUtils {

    public static final int LIMIT_DEFAULT_VALUE = 2;

    private static GenreUtils instance;

    private final Faker faker;

    private GenreUtils() {
        this.faker = Faker.instance();
    }

    public static GenreUtils getInstance() {
        if (instance == null) {
            instance = new GenreUtils();
        }

        return instance;
    }

    public List<Genre> generateGenres(int limit) {
        var genres = Genre.values();

        return Stream.generate(() -> genres[faker.number().numberBetween(0, genres.length - 1)])
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Genre> generateGenres() {
        return generateGenres(LIMIT_DEFAULT_VALUE);
    }

}
