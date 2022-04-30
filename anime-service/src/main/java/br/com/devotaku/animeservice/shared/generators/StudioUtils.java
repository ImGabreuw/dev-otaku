package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.value.objects.Studio;
import com.github.javafaker.Faker;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudioUtils {

    public static final int LIMIT_DEFAULT_VALUE = 2;

    private static StudioUtils instance;

    private final Faker faker;

    private StudioUtils() {
        this.faker = Faker.instance();
    }

    public static StudioUtils getInstance() {
        if (instance == null) {
            instance = new StudioUtils();
        }

        return instance;
    }

    public String generateStudioValue() {
        return faker.company().name();
    }

    public Studio generateStudio() {
        return new Studio(generateStudioValue());
    }

    public Set<Studio> generateStudioSequence(int limit) {
        return Stream.generate(this::generateStudio)
                .limit(limit)
                .collect(Collectors.toSet());
    }

    public Set<Studio> generateStudioSequence() {
        return generateStudioSequence(LIMIT_DEFAULT_VALUE);
    }

    public static boolean isNotBlank(Studio studio) {
        return !studio.value().isBlank();
    }

}
