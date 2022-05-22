package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.enums.Status;
import br.com.devotaku.animeservice.shared.helper.RandomHelper;
import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class StatusUtils {

    private static StatusUtils instance;

    public static StatusUtils getInstance() {
        if (instance == null) {
            instance = new StatusUtils();
        }

        return instance;
    }

    public Status generateStatus() {
        var status = Status.values();

        return status[RandomHelper.number(0, status.length - 1)];
    }

}
