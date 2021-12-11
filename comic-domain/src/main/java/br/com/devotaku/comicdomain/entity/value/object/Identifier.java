package br.com.devotaku.comicdomain.entity.value.object;

import br.com.devotaku.comicdomain.entity.Comic;
import br.com.devotaku.comicdomain.entity.pagination.PageInfo;
import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Stream;

public record Identifier(Long value) {

    @SneakyThrows
    public static <T extends Comic> T increment(T entity) {
        Comic clone = entity.clone();
        clone.setId(new Identifier(entity.getId().value() + 1L));

        return (T) clone;
    }

    public static List<Identifier> generateSequence(long start, long end) {
        return Stream.iterate(
                        new Identifier(start),
                        identifier -> new Identifier(identifier.value() + 1L)
                )
                .limit(end)
                .toList();
    }

    public static List<Identifier> generateSequenceFrom(PageInfo pageInfo) {
        // interval = 9     interval = 19
        // 1 -> 1 - 10      1 -> 1 - 20 -> 1 * 19 = 19 -> 20 - 19 = 1
        // 2 -> 11 - 20     2 -> 21 - 40 -> 2 * 19 = 38 -> 40 - 28 = 2 -> Portanto:  (pageNumber + 1) * interval + (pageNumber + 1)
        // 3 -> 21 - 30     3 -> 41 - 60
        // 4 -> 31 - 40     4 -> 61 - 80
        int interval = pageInfo.pageSize() - 1;
        int end = (pageInfo.pageNumber() + 1) * interval + (pageInfo.pageNumber() + 1);
        int start = end - interval;

        return generateSequence(start, end);
    }

}
