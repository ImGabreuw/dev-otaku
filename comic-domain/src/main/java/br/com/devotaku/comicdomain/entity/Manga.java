package br.com.devotaku.comicdomain.entity;

import br.com.devotaku.comicdomain.entity.value.object.AlternativeName;
import br.com.devotaku.comicdomain.entity.value.object.Author;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.shared.validation.SelfValidation;

import java.util.List;

public final class Manga extends Comic implements SelfValidation<Manga> {

    public Manga(Identifier id, String title, List<AlternativeName> alternativeNames, List<Author> authors, List<Genre> genres, String description, Status status, Double score) {
        super(id, title, alternativeNames, authors, genres, description, status, score);

        validate(this);
    }

    @Override
    public int compareTo(Comic comic) {
        return Double.compare(getScore(), comic.getScore());
    }

}
