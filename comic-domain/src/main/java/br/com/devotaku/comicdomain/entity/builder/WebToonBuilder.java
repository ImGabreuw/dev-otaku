package br.com.devotaku.comicdomain.entity.builder;

import br.com.devotaku.comicdomain.entity.Genre;
import br.com.devotaku.comicdomain.entity.Status;
import br.com.devotaku.comicdomain.entity.WebToon;
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
public class WebToonBuilder {

    private Identifier id;

    private String title;

    private List<AlternativeName> alternativeNames;

    private List<Author> authors;

    private List<Genre> genres;

    private String description;

    private Status status;

    private Double score;

    public static WebToonBuilder builder() {
        return new WebToonBuilder();
    }

    public WebToonBuilder id(Identifier id) {
        this.id = id;
        return this;
    }

    public WebToonBuilder id(Long id) {
        this.id = new Identifier(id);
        return this;
    }

    public WebToonBuilder title(String title) {
        this.title = title;
        return this;
    }

    public WebToonBuilder alternativeNames(AlternativeName... alternativeNames) {
        this.alternativeNames = Arrays.asList(alternativeNames);
        return this;
    }

    public WebToonBuilder alternativeNames(List<AlternativeName> alternativeNames) {
        this.alternativeNames = alternativeNames;
        return this;
    }

    public WebToonBuilder authors(Author... authors) {
        this.authors = Arrays.asList(authors);
        return this;
    }

    public WebToonBuilder authors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    public WebToonBuilder genres(Genre... genres) {
        this.genres = Arrays.asList(genres);
        return this;
    }

    public WebToonBuilder genres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public WebToonBuilder description(String description) {
        this.description = description;
        return this;
    }

    public WebToonBuilder status(Status status) {
        this.status = status;
        return this;
    }

    public WebToonBuilder finished() {
        this.status = FINISHED;
        return this;
    }

    public WebToonBuilder publishing() {
        this.status = PUBLISHING;
        return this;
    }

    public WebToonBuilder score(Double score) {
        this.score = score;
        return this;
    }

    public WebToon build() {
        return new WebToon(id, title, alternativeNames, authors, genres, description, status, score);
    }

}
