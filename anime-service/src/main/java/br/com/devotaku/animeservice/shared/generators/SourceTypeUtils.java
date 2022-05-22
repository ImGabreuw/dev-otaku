package br.com.devotaku.animeservice.shared.generators;

import br.com.devotaku.animeservice.domain.entities.enums.SourceType;
import br.com.devotaku.animeservice.shared.helper.RandomHelper;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SourceTypeUtils {

    private static SourceTypeUtils instance;

    public static SourceTypeUtils getInstance() {
        if (instance == null) {
            instance = new SourceTypeUtils();
        }

        return instance;
    }

    public SourceType generateSourceType() {
        var sourceTypes = SourceType.values();

        return sourceTypes[RandomHelper.number(0, sourceTypes.length - 1)];
    }

}
