package br.com.devotaku.animeservice.domain.ports.mapper;

/**
 * Contract of mapper classes.
 *
 * @param <D> <bold>D</bold>omain entity
 * @param <A> <bold>A</bold>pplication entity
 */
public interface IMapper<D, A> {

    A mapToApp(D domain);

    D mapToDomain(A app);

}
