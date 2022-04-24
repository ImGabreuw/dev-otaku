package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.domain.entities.value.objects.AlternativeName;
import com.github.javafaker.Faker;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlternativeNameUtils {

    public static final int LIMIT_DEFAULT_VALUE = 2;

    private static AlternativeNameUtils instance;

    private final Faker faker;

    private AlternativeNameUtils() {
        this.faker = Faker.instance();
    }

    public static AlternativeNameUtils getInstance() {
        if (instance == null) {
            instance = new AlternativeNameUtils();
        }

        return instance;
    }

    public AlternativeName generateAlternativeName() {
        return new AlternativeName(
                generateAlternativeNameValue()
        );
    }

    public String generateAlternativeNameValue() {
        return faker.company().name();
    }

    public Set<AlternativeName> generateAlternativeNameSequence(int limit) {
        return Stream.generate(this::generateAlternativeName)
                .limit(limit)
                .collect(Collectors.toSet());
    }

    public Set<AlternativeName> generateAlternativeNameSequence() {
        return Stream.generate(this::generateAlternativeName)
                .limit(LIMIT_DEFAULT_VALUE)
                .collect(Collectors.toSet());
    }

}
