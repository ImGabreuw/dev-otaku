package br.com.devotaku.shared.pagination;

import br.com.devotaku.shared.validation.SelfValidation;
import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * <i>Wrapper class</i> para armazenar informações de paginação.
 *
 * @author ImGabreuw
 */
public record PageInfo(
        @PositiveOrZero(message = "O campo 'pageNumber' deve conter um valor maior ou igual a 0")
        int pageNumber,

        @Positive(message = "O campo 'pageNumber' deve conter um valor maior do que 0")
        int pageSize,

        int pageInterval,

        int firstElementPosition,

        int lastElementPosition
) implements SelfValidation<PageInfo> {

    public PageInfo(int pageNumber, int pageSize, int pageInterval, int firstElementPosition, int lastElementPosition) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageInterval = pageInterval;
        this.firstElementPosition = firstElementPosition;
        this.lastElementPosition = lastElementPosition;

        validate(this);
    }

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
