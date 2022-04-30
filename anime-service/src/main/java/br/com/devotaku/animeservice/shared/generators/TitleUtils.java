package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.value.objects.Title;
import com.github.javafaker.Faker;

public class TitleUtils {

    private static TitleUtils instance;

    private final Faker faker;

    private TitleUtils() {
        this.faker = Faker.instance();
    }

    public static TitleUtils getInstance() {
        if (instance == null) {
            instance = new TitleUtils();
        }

        return instance;
    }

    public String generateTitleValue() {
        return faker.name().title();
    }

    public Title generateTitle() {
        return new Title(generateTitleValue());
    }

}
