package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.value.objects.Identifier;
import br.com.devotaku.animeservice.shared.page.PageInfo;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.stream.Stream;

public class IdentifierUtils {

    public static final Long MAXIMUM_DEFAULT_VALUE = 50L;

    private static IdentifierUtils instance;

    private final Faker faker;

    private IdentifierUtils() {
        this.faker = Faker.instance();
    }

    public static IdentifierUtils getInstance() {
        if (instance == null) {
            instance = new IdentifierUtils();
        }

        return instance;
    }

    public Identifier generateIdentifier(long maximum) {
        return new Identifier(
                generateIdentifierValue(maximum)
        );
    }

    public Identifier generateIdentifier() {
        return new Identifier(
                generateIdentifierValue(MAXIMUM_DEFAULT_VALUE)
        );
    }

    public long generateIdentifierValue(long maximum) {
        return faker.number().numberBetween(1, maximum);
    }

    public long generateIdentifierValue() {
        return faker.number().numberBetween(1, MAXIMUM_DEFAULT_VALUE);
    }

    public long generateInvalidIdentifierValue() {
        return faker.number().numberBetween(0, -MAXIMUM_DEFAULT_VALUE);
    }

    public List<Identifier> generateIdentifierSequence(long start, long end) {
        return Stream.iterate(
                        new Identifier(start),
                        previous -> new Identifier(previous.value() + 1L)
                )
                .limit(end)
                .toList();
    }

    public List<Identifier> generateIdentifierSequenceFrom(PageInfo pageInfo) {
        return generateIdentifierSequence(
                pageInfo.lastElementPosition(),
                pageInfo.firstElementPosition()
        );
    }

}
