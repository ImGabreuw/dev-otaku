package br.com.devotaku.comicdomain.gateway.repository;

import br.com.devotaku.comicdomain.entity.Comic;
import br.com.devotaku.comicdomain.entity.Manga;
import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.comicdomain.entity.builder.ManhwaBuilder;
import br.com.devotaku.comicdomain.entity.pagination.PageInfo;
import br.com.devotaku.comicdomain.entity.value.object.AlternativeName;
import br.com.devotaku.comicdomain.entity.value.object.Author;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.comicdomain.gateway.repository.ManhwaRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static br.com.devotaku.comicdomain.entity.Genre.*;
import static br.com.devotaku.comicdomain.entity.Genre.SUPERNATURAL;
import static br.com.devotaku.comicdomain.entity.Status.PUBLISHING;

public class ManhwaRepositoryMock implements ManhwaRepository {

    private final Manhwa baseManhwa = ManhwaBuilder.builder()
            .id(new Identifier(1L))
            .title("Tales Of Demons And Gods")
            .alternativeNames(new AlternativeName("tdg"))
            .authors(new Author("Mad Snail"))
            .genres(MARTIAL_ARTS, ADVENTURE, SHOUNEN, SUPERNATURAL)
            .description("Nie Li, o mais poderoso Espiritualista Demoníaco e estando no topo do mundo marcial, perde sua vida durante a batalha com o Imperador Sábio e as seis bestas de nível divino, e sua alma volta ao passado para quando ele tinha 13 anos. Embora ele seja o mais fraco em sua classe, com o talento mais baixo no reino da alma Vermelho – o mais fraco dos reinos – com a ajuda de seu vasto conhecimento acumulado na sua vida passada, cresce mais rápido do que todos.Agora, ele irá tentar proteger a cidade que no futuro será invadida pelas bestas e que acabou sendo destruída, assim como sua amada, seus amigos e sua família que morreram pelo ataque das mesmas, e destruir a família Sagrada que abandonaram seus deveres e traíram a cidade em sua vida passada.")
            .status(PUBLISHING)
            .score(9.18)
            .build();
    
    @Override
    public Optional<Manhwa> findById(Identifier identifier) {
        if (identifier.value() != 1L) {
            return Optional.empty();
        }
        
        return Optional.of(baseManhwa);
    }

    @Override
    public List<Manhwa> findAll(PageInfo pageInfo) {
        return Stream.iterate(baseManhwa, Identifier::incrementEntityID)
                .limit(pageInfo.pageSize())
                .toList();
    }

    @Override
    public Optional<Manhwa> findByTitleOrAlternativesName(String manhwaName) {
        if (!baseManhwa.hasTitleOrAlternativeNamesEqualsTo(manhwaName)) {
            return Optional.empty();
        }

        return Optional.of(baseManhwa);
    }

    @Override
    public List<Manhwa> fetchTopUseCase(PageInfo pageInfo) {
        int limit = (pageInfo.pageNumber() + 1) * pageInfo.pageSize();

        List<Manhwa> mangas = Comic.generateRandomScore(baseManhwa, limit);
        mangas.sort(Comparator.comparing(Comic::getScore).reversed());

        return mangas.subList(pageInfo.start() - 1, pageInfo.end());
    }

    @Override
    public List<Manhwa> findAllByFinished(PageInfo pageInfo) {
        return Stream.generate(() -> {
                    Manhwa clone = (Manhwa) baseManhwa.clone();
                    clone.finished();
                    return clone;
                })
                .limit(pageInfo.pageSize())
                .toList();
    }

    @Override
    public List<Manhwa> findAllByPublishing(PageInfo pageInfo) {
        return Stream
                .generate(() -> (Manhwa) baseManhwa.clone())
                .limit(pageInfo.pageSize())
                .toList();
    }
    
}
