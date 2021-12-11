package br.com.devotaku.comicdomain.entity.builder;

import br.com.devotaku.comicdomain.entity.Genre;
import br.com.devotaku.comicdomain.entity.Manga;
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
public class MangaBuilder {

    private Identifier id;

    private String title;

    private List<AlternativeName> alternativeNames;

    private List<Author> authors;

    private List<Genre> genres;

    private String description;

    private Status status;

    private Double score;

    public static MangaBuilder builder() {
        return new MangaBuilder();
    }

    public MangaBuilder id(Identifier id) {
        this.id = id;
        return this;
    }

    public MangaBuilder id(Long id) {
        this.id = new Identifier(id);
        return this;
    }

    public MangaBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MangaBuilder alternativeNames(AlternativeName... alternativeNames) {
        this.alternativeNames = Arrays.asList(alternativeNames);
        return this;
    }

    public MangaBuilder alternativeNames(List<AlternativeName> alternativeNames) {
        this.alternativeNames = alternativeNames;
        return this;
    }

    public MangaBuilder authors(Author... authors) {
        this.authors = Arrays.asList(authors);
        return this;
    }

    public MangaBuilder authors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    public MangaBuilder genres(Genre... genres) {
        this.genres = Arrays.asList(genres);
        return this;
    }

    public MangaBuilder genres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public MangaBuilder description(String description) {
        this.description = description;
        return this;
    }

    public MangaBuilder status(Status status) {
        this.status = status;
        return this;
    }

    public MangaBuilder finished() {
        this.status = FINISHED;
        return this;
    }

    public MangaBuilder publishing() {
        this.status = PUBLISHING;
        return this;
    }

    public MangaBuilder score(Double score) {
        this.score = score;
        return this;
    }

    public Manga build() {
        return new Manga(id, title, alternativeNames, authors, genres, description, status, score);
    }

}
