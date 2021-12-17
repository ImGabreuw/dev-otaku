package br.com.devotaku.shared.pagination;

/**
 * <i>Wrapper class</i> para armazenar informações de paginação.
 *
 * @author ImGabreuw
 */
public record PageInfo(
        int pageNumber,
        int pageSize,
        int pageInterval,
        int firstElementPosition,
        int lastElementPosition
) {

    /**
     * <i>Factory method</i> para criar uma instância de {@link PageInfo} com as configurações padrão.
     *
     * @param pageNumber o número da página.
     * @param pageSize o tamanho da página.
     * @return uma instância de {@link PageInfo}.
     */
    public static PageInfo create(int pageNumber, int pageSize) {
        int pageInterval = pageSize - 1;
        int lastElementPosition = (pageNumber + 1) * pageInterval + (pageNumber + 1);
        int firstElementPosition = lastElementPosition - pageInterval;

        return new PageInfo(pageNumber, pageSize, pageInterval, lastElementPosition, firstElementPosition);
    }

}
