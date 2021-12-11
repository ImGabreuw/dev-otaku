package br.com.devotaku.comicdomain.entity.builder;

import br.com.devotaku.comicdomain.entity.Genre;
import br.com.devotaku.comicdomain.entity.Manhwa;
import br.com.devotaku.comicdomain.entity.Status;
import br.com.devotaku.comicdomain.entity.value.object.AlternativeName;
import br.com.devotaku.comicdomain.entity.value.object.Author;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static br.com.devotaku.comicdomain.entity.Status.FINISHED;
import static br.com.devotaku.comicdomain.entity.Status.PUBLISHING;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ManhwaBuilder {

    private Identifier id;

    private String title;

    private List<AlternativeName> alternativeNames;

    private List<Author> authors;

    private List<Genre> genres;

    private String description;

    private Status status;

    private Double score;

    public static ManhwaBuilder builder() {
        return new ManhwaBuilder();
    }

    public ManhwaBuilder id(Identifier id) {
        this.id = id;
        return this;
    }

    public ManhwaBuilder id(Long id) {
        this.id = new Identifier(id);
        return this;
    }

    public ManhwaBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ManhwaBuilder alternativeNames(AlternativeName... alternativeNames) {
        this.alternativeNames = Arrays.asList(alternativeNames);
        return this;
    }

    public ManhwaBuilder alternativeNames(List<AlternativeName> alternativeNames) {
        this.alternativeNames = alternativeNames;
        return this;
    }

    public ManhwaBuilder authors(Author... authors) {
        this.authors = Arrays.asList(authors);
        return this;
    }

    public ManhwaBuilder authors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    public ManhwaBuilder genres(Genre... genres) {
        this.genres = Arrays.asList(genres);
        return this;
    }

    public ManhwaBuilder genres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public ManhwaBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ManhwaBuilder status(Status status) {
        this.status = status;
        return this;
    }

    public ManhwaBuilder finished() {
        this.status = FINISHED;
        return this;
    }

    public ManhwaBuilder publishing() {
        this.status = PUBLISHING;
        return this;
    }

    public ManhwaBuilder score(Double score) {
        this.score = score;
        return this;
    }

    public Manhwa build() {
        return new Manhwa(id, title, alternativeNames, authors, genres, description, status, score);
    }

}
