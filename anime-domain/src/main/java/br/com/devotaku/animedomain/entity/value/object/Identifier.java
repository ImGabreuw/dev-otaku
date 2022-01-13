package br.com.devotaku.animedomain.entity.value.object;

import br.com.devotaku.animedomain.entity.Anime;
import br.com.devotaku.shared.pagination.PageInfo;
import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Stream;

public record Identifier(Long value) {

    // FIXME: 09/01/2022 Remove duplicated
    @SneakyThrows
    public static <T extends Anime & Cloneable> T increment(T entity) {
        Anime clone = entity.clone();
        clone.setId(new Identifier(entity.getId().value() + 1L));

        return (T) clone;
    }

    // FIXME: 09/01/2022 Remove duplicated
    public static List<Identifier> generateIDSequence(long start, long end) {
        return Stream.iterate(
                        new Identifier(start),
                        identifier -> new Identifier(identifier.value() + 1L)
                )
                .limit(end)
                .toList();
    }

    // FIXME: 09/01/2022 Remove duplicated
    public static List<Identifier> generateIDSequenceFrom(PageInfo pageInfo) {
        // pageInterval = 9     pageInterval = 19
        // 1 -> 1 - 10      1 -> 1 - 20 -> 1 * 19 = 19 -> 20 - 19 = 1
        // 2 -> 11 - 20     2 -> 21 - 40 -> 2 * 19 = 38 -> 40 - 28 = 2 -> Portanto:  (pageNumber + 1) * pageInterval + (pageNumber + 1)
        // 3 -> 21 - 30     3 -> 41 - 60
        // 4 -> 31 - 40     4 -> 61 - 80
        return generateIDSequence(pageInfo.lastElementPosition(), pageInfo.firstElementPosition());
    }

}
