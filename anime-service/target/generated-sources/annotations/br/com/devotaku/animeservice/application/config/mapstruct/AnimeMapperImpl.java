package br.com.devotaku.animeservice.application.config.mapstruct;

import br.com.devotaku.animeservice.application.config.mapstruct.methods.AlternativeNamesMethod;
import br.com.devotaku.animeservice.application.config.mapstruct.methods.DescriptionMethod;
import br.com.devotaku.animeservice.application.config.mapstruct.methods.EndedAtMethod;
import br.com.devotaku.animeservice.application.config.mapstruct.methods.EpisodesMethod;
import br.com.devotaku.animeservice.application.config.mapstruct.methods.IdentifierMethod;
import br.com.devotaku.animeservice.application.config.mapstruct.methods.ProducerMethod;
import br.com.devotaku.animeservice.application.config.mapstruct.methods.ScoreMethod;
import br.com.devotaku.animeservice.application.config.mapstruct.methods.StudioMethod;
import br.com.devotaku.animeservice.application.config.mapstruct.methods.TitleMethod;
import br.com.devotaku.animeservice.application.dataprovider.entities.AnimeEntity;
import br.com.devotaku.animeservice.domain.entities.Anime;
import br.com.devotaku.animeservice.domain.entities.enums.Genre;
import br.com.devotaku.animeservice.domain.entities.enums.SourceType;
import br.com.devotaku.animeservice.domain.entities.enums.Status;
import br.com.devotaku.animeservice.domain.entities.value.objects.AlternativeName;
import br.com.devotaku.animeservice.domain.entities.value.objects.Description;
import br.com.devotaku.animeservice.domain.entities.value.objects.Episodes;
import br.com.devotaku.animeservice.domain.entities.value.objects.Identifier;
import br.com.devotaku.animeservice.domain.entities.value.objects.Producer;
import br.com.devotaku.animeservice.domain.entities.value.objects.Score;
import br.com.devotaku.animeservice.domain.entities.value.objects.Studio;
import br.com.devotaku.animeservice.domain.entities.value.objects.Title;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-11T18:48:08-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class AnimeMapperImpl implements AnimeMapper {

    private final IdentifierMethod identifierMethod;
    private final TitleMethod titleMethod;
    private final AlternativeNamesMethod alternativeNamesMethod;
    private final DescriptionMethod descriptionMethod;
    private final ScoreMethod scoreMethod;
    private final EpisodesMethod episodesMethod;
    private final EndedAtMethod endedAtMethod;
    private final ProducerMethod producerMethod;
    private final StudioMethod studioMethod;

    @Autowired
    public AnimeMapperImpl(IdentifierMethod identifierMethod, TitleMethod titleMethod, AlternativeNamesMethod alternativeNamesMethod, DescriptionMethod descriptionMethod, ScoreMethod scoreMethod, EpisodesMethod episodesMethod, EndedAtMethod endedAtMethod, ProducerMethod producerMethod, StudioMethod studioMethod) {

        this.identifierMethod = identifierMethod;
        this.titleMethod = titleMethod;
        this.alternativeNamesMethod = alternativeNamesMethod;
        this.descriptionMethod = descriptionMethod;
        this.scoreMethod = scoreMethod;
        this.episodesMethod = episodesMethod;
        this.endedAtMethod = endedAtMethod;
        this.producerMethod = producerMethod;
        this.studioMethod = studioMethod;
    }

    @Override
    public AnimeEntity mapToApp(Anime domain) {
        if ( domain == null ) {
            return null;
        }

        AnimeEntity animeEntity = new AnimeEntity();

        animeEntity.setId( identifierMethod.mapToApp( domain.getId() ) );
        animeEntity.setTitle( titleMethod.mapToApp( domain.getTitle() ) );
        animeEntity.setAlternativeNames( alternativeNamesMethod.mapToApp( domain.getAlternativeNames() ) );
        animeEntity.setDescription( descriptionMethod.mapToApp( domain.getDescription() ) );
        animeEntity.setScore( scoreMethod.mapToApp( domain.getScore() ) );
        animeEntity.setEpisodes( episodesMethod.mapToApp( domain.getEpisodes() ) );
        animeEntity.setEndedAt( endedAtMethod.mapToApp( domain.getEndedAt() ) );
        animeEntity.setProducers( producerMethod.mapToApp( domain.getProducers() ) );
        animeEntity.setStudios( studioMethod.mapToApp( domain.getStudios() ) );
        animeEntity.setStatus( domain.getStatus() );
        animeEntity.setLaunchedAt( domain.getLaunchedAt() );
        animeEntity.setSource( domain.getSource() );
        List<Genre> list = domain.getGenres();
        if ( list != null ) {
            animeEntity.setGenres( new ArrayList<Genre>( list ) );
        }

        return animeEntity;
    }

    @Override
    public Anime mapToDomain(AnimeEntity other) {
        if ( other == null ) {
            return null;
        }

        Identifier id = null;
        Title title = null;
        Set<AlternativeName> alternativeNames = null;
        Description description = null;
        Score score = null;
        Episodes episodes = null;
        Set<Producer> producers = null;
        Set<Studio> studios = null;
        Status status = null;
        LocalDate launchedAt = null;
        LocalDate endedAt = null;
        SourceType source = null;
        List<Genre> genres = null;

        id = identifierMethod.mapToDomain( other.getId() );
        title = titleMethod.mapToDomain( other.getTitle() );
        alternativeNames = alternativeNamesMethod.mapToDomain( other.getAlternativeNames() );
        description = descriptionMethod.mapToDomain( other.getDescription() );
        score = scoreMethod.mapToDomain( other.getScore() );
        episodes = episodesMethod.mapToDomain( other.getEpisodes() );
        producers = producerMethod.mapToDomain( other.getProducers() );
        studios = studioMethod.mapToDomain( other.getStudios() );
        status = other.getStatus();
        launchedAt = other.getLaunchedAt();
        endedAt = other.getEndedAt();
        source = other.getSource();
        List<Genre> list = other.getGenres();
        if ( list != null ) {
            genres = new ArrayList<Genre>( list );
        }

        Anime anime = new Anime( id, title, alternativeNames, description, score, episodes, status, launchedAt, endedAt, producers, studios, source, genres );

        return anime;
    }
}
