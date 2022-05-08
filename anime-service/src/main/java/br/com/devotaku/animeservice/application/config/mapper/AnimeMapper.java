package br.com.devotaku.animeservice.application.config.mapper;

import br.com.devotaku.animeservice.application.config.mapper.annotations.ToApp;
import br.com.devotaku.animeservice.application.config.mapper.annotations.ToDomain;
import br.com.devotaku.animeservice.application.config.mapper.annotations.alternative.names.AlternativeNamesMapper;
import br.com.devotaku.animeservice.application.config.mapper.annotations.description.DescriptionMapper;
import br.com.devotaku.animeservice.application.config.mapper.annotations.endedat.EndedAtMapper;
import br.com.devotaku.animeservice.application.config.mapper.annotations.episodes.EpisodesMapper;
import br.com.devotaku.animeservice.application.config.mapper.annotations.identifier.IdentifierMapper;
import br.com.devotaku.animeservice.application.config.mapper.annotations.producer.ProducerMapper;
import br.com.devotaku.animeservice.application.config.mapper.annotations.score.ScoreMapper;
import br.com.devotaku.animeservice.application.config.mapper.annotations.studio.StudioMapper;
import br.com.devotaku.animeservice.application.config.mapper.annotations.title.TitleMapper;
import br.com.devotaku.animeservice.application.config.mapper.methods.*;
import br.com.devotaku.animeservice.application.dataprovider.entities.AnimeEntity;
import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.ports.mapper.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

/**
 * <h2>References</h2>
 * <ul>
 *     <li><a href="https://www.baeldung.com/mapstruct">"Quick Guide to MapStruct" - Baeldung</a></li>
 *     <li><a href="https://mapstruct.org/documentation/dev/reference/html/">"MapStruct 1.5.0.RC1 Reference Guide" - MapStruct</a></li>
 * </ul>
 */

@Mapper(
        componentModel = "spring",
        uses = {IdentifierMethod.class, TitleMethod.class, AlternativeNamesMethod.class, DescriptionMethod.class, ScoreMethod.class, EpisodesMethod.class, EndedAtMethod.class, ProducerMethod.class, StudioMethod.class,},
        injectionStrategy = CONSTRUCTOR
)
public interface AnimeMapper extends IMapper<Anime, AnimeEntity> {

    @Override
    @Mappings({
            @Mapping(target = "id", qualifiedBy = {IdentifierMapper.class, ToApp.class}),
            @Mapping(target = "title", qualifiedBy = {TitleMapper.class, ToApp.class}),
            @Mapping(target = "alternativeNames", qualifiedBy = {AlternativeNamesMapper.class, ToApp.class}),
            @Mapping(target = "description", qualifiedBy = {DescriptionMapper.class, ToApp.class}),
            @Mapping(target = "score", qualifiedBy = {ScoreMapper.class, ToApp.class}),
            @Mapping(target = "episodes", qualifiedBy = {EpisodesMapper.class, ToApp.class}),
            @Mapping(target = "endedAt", qualifiedBy = {EndedAtMapper.class, ToApp.class}),
            @Mapping(target = "producers", qualifiedBy = {ProducerMapper.class, ToApp.class}),
            @Mapping(target = "studios", qualifiedBy = {StudioMapper.class, ToApp.class}),
    })
    AnimeEntity mapToApp(Anime domain);

    @Override
    @Mappings({
            @Mapping(target = "id", qualifiedBy = {IdentifierMapper.class, ToDomain.class}),
            @Mapping(target = "title", qualifiedBy = {TitleMapper.class, ToDomain.class}),
            @Mapping(target = "alternativeNames", qualifiedBy = {AlternativeNamesMapper.class, ToDomain.class}),
            @Mapping(target = "description", qualifiedBy = {DescriptionMapper.class, ToDomain.class}),
            @Mapping(target = "score", qualifiedBy = {ScoreMapper.class, ToDomain.class}),
            @Mapping(target = "episodes", qualifiedBy = {EpisodesMapper.class, ToDomain.class}),
            @Mapping(target = "producers", qualifiedBy = {ProducerMapper.class, ToDomain.class}),
            @Mapping(target = "studios", qualifiedBy = {StudioMapper.class, ToDomain.class}),
    })
    Anime mapToDomain(AnimeEntity other);

}
