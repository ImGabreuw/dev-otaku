package br.com.devotaku.comicdomain.gateway;

import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.comicdomain.entity.builder.MangaBuilder;
import br.com.devotaku.comicdomain.entity.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.AlternativeName;
import br.com.devotaku.comicdomain.entity.value.object.Author;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static br.com.devotaku.comicdomain.entity.Genre.*;
import static br.com.devotaku.comicdomain.entity.Status.PUBLISHING;

public class MangaRepositoryMock implements MangaRepository {

    @Override
    public Optional<Manga> findById(Identifier identifier) {
        if (identifier.value() != 1L) {
            return Optional.empty();
        }

        return Optional.of(MangaBuilder.builder()
                .id(1L)
                .title("One Piece")
                .alternativeNames(new AlternativeName("ONE PIECE"))
                .authors(new Author("Oda Eiichiro"))
                .genres(ACTION, ADVENTURE, COMEDY, FANTASY)
                .description("One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!")
                .status(PUBLISHING)
                .score(9.56)
                .build());
    }

    @Override
    public List<Manga> findAll(PageInfo pageInfo) {
        Manga template = MangaBuilder.builder()
                .id(1L)
                .title("One Piece")
                .alternativeNames(new AlternativeName("ONE PIECE"))
                .authors(new Author("Oda Eiichiro"))
                .genres(ACTION, ADVENTURE, COMEDY, FANTASY)
                .description("One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!")
                .status(PUBLISHING)
                .score(9.56)
                .build();

        return Stream.iterate(template, Identifier::increment)
                .limit(pageInfo.pageSize())
                .toList();
    }

    @Override
    public Optional<Manga> findByTitleOrAlternativesName(String mangaName) {
        Manga manga = MangaBuilder.builder()
                .id(1L)
                .title("One Piece")
                .alternativeNames(new AlternativeName("ONE PIECE"))
                .authors(new Author("Oda Eiichiro"))
                .genres(ACTION, ADVENTURE, COMEDY, FANTASY)
                .description("One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Ser o Rei Dos Piratas!!")
                .status(PUBLISHING)
                .score(9.56)
                .build();

        if (!manga.hasTitleOrAlternativeNames(mangaName)) {
            return Optional.empty();
        }

        return Optional.of(manga);
    }

}