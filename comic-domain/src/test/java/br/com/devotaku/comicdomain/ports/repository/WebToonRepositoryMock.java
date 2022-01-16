package br.com.devotaku.comicdomain.ports.repository;

import br.com.devotaku.comicdomain.entity.Comic;
import br.com.devotaku.comicdomain.entity.WebToon;
import br.com.devotaku.comicdomain.entity.builder.WebToonBuilder;
import br.com.devotaku.shared.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.Author;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static br.com.devotaku.comicdomain.entity.enums.Genre.*;
import static br.com.devotaku.comicdomain.entity.enums.Status.PUBLISHING;

public class WebToonRepositoryMock implements WebToonRepository {

    private final WebToon baseWebToon = WebToonBuilder.builder()
            .id(new Identifier(1L))
            .title("Solo Leveling")
            .authors(new Author("Jang Sung-Lak"))
            .genres(ACTION, ADVENTURE, SHOUNEN)
            .description("Dez anos atrás, depois do \"Portal\" que conecta o mundo real com um mundo de montros se abriu, algumas pessoas comuns receberam o poder de caçar os monstros do portal. Eles são conhecidos como caçadores. Porém, nem todos os caçadores são fortes. Meu nome é Sung Jin-Woo, um caçador de rank E. Eu sou alguém que tem que arriscar a própria vida nas dungeons mais fracas, \"O mais fraco do mundo\". Sem ter nenhuma habilidade à disposição, eu mal consigo dinheiro nas dungeons de baixo nível... Ao menos até eu encontrar uma dungeon escondida com a maior dificuldade dentro do Rank D! No fim, enquanto aceitava minha morte, eu ganhei um novo poder!")
            .status(PUBLISHING)
            .score(9.37)
            .build();


    @Override
    public Optional<WebToon> findById(Identifier identifier) {
        if (identifier.value() != 1L) {
            return Optional.empty();
        }

        return Optional.of(baseWebToon);
    }

    @Override
    public List<WebToon> findAll(PageInfo pageInfo) {
        return Stream.iterate(baseWebToon, Identifier::incrementEntityID)
                .limit(pageInfo.pageSize())
                .toList();
    }

    @Override
    public Optional<WebToon> findByTitleOrAlternativesName(String webToonName) {
        if (!baseWebToon.hasTitleOrAlternativeNamesEqualsTo(webToonName)) {
            return Optional.empty();
        }

        return Optional.of(baseWebToon);
    }

    @Override
    public List<WebToon> fetchTopUseCase(PageInfo pageInfo) {
        int limit = (pageInfo.pageNumber() + 1) * pageInfo.pageSize();

        List<WebToon> mangas = Comic.generateRandomScore(baseWebToon, limit);
        mangas.sort(Comparator.comparing(Comic::getScore).reversed());

        return mangas.subList(pageInfo.lastElementPosition() - 1, pageInfo.firstElementPosition());
    }

    @Override
    public List<WebToon> findAllByFinished(PageInfo pageInfo) {
        return Stream.generate(() -> {
                    WebToon clone = (WebToon) baseWebToon.clone();
                    clone.finished();
                    return clone;
                })
                .limit(pageInfo.pageSize())
                .toList();
    }

    @Override
    public List<WebToon> findAllByPublishing(PageInfo pageInfo) {
        return Stream
                .generate(() -> (WebToon) baseWebToon.clone())
                .limit(pageInfo.pageSize())
                .toList();
    }

}
