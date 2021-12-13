package br.com.devotaku.comicdomain.entity.pagination;

public record PageInfo(
        int pageNumber,
        int pageSize,
        int interval,
        int end,
        int start
) {

    public static PageInfo create(int pageNumber, int pageSize) {
        int interval = pageSize - 1;
        int end = (pageNumber + 1) * interval + (pageNumber + 1);
        int start = end - interval;

        return new PageInfo(pageNumber, pageSize, interval, end, start);
    }

}
