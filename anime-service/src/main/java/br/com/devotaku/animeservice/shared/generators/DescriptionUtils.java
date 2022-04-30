package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.value.objects.Description;
import com.github.javafaker.Faker;

public class DescriptionUtils {

    public static final int LENGTH_DEFAULT_VALUE = 50;

    private static DescriptionUtils instance;

    private final Faker faker;

    private DescriptionUtils() {
        this.faker = Faker.instance();
    }

    public static DescriptionUtils getInstance() {
        if (instance == null) {
            instance = new DescriptionUtils();
        }

        return instance;
    }

    public String generateDescriptionValue(int length) {
        StringBuilder builder = new StringBuilder();

        while (true) {
            if (builder.length() == length) break;

            if (builder.length() > length) {
                builder.delete(length, builder.length());
                break;
            }

            builder
                    .append(faker.lorem().word())
                    .append(" ");
        }

        return builder.toString();
    }

    public String generateDescriptionValue() {
        return generateDescriptionValue(LENGTH_DEFAULT_VALUE);
    }

    public Description generateDescription(int length) {
        return new Description(
                generateDescriptionValue(length)
        );
    }

    public Description generateDescription() {
        return generateDescription(LENGTH_DEFAULT_VALUE);
    }

}
