package br.com.devotaku.animeservice.utils;

import br.com.devotaku.animeservice.domain.entities.value.objects.Producer;
import com.github.javafaker.Faker;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProducerUtils {

    public static final int LIMIT_DEFAULT_VALUE = 2;

    private static ProducerUtils instance;

    private final Faker faker;

    private ProducerUtils() {
        this.faker = Faker.instance();
    }

    public static ProducerUtils getInstance() {
        if (instance == null) {
            instance = new ProducerUtils();
        }

        return instance;
    }

    public String generateProducerValue() {
        return faker.company().name();
    }

    public Producer generateProducer() {
        return new Producer(generateProducerValue());
    }

    public Set<Producer> generateProducerSequence(int limit) {
        return Stream.generate(this::generateProducer)
                .limit(limit)
                .collect(Collectors.toSet());
    }

    public Set<Producer> generateProducerSequence() {
        return generateProducerSequence(LIMIT_DEFAULT_VALUE);
    }

    public static boolean isNotBlank(Producer producer) {
        return !producer.value().isBlank();
    }

}
