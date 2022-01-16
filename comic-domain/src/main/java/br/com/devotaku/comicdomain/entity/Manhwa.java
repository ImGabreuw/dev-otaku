package br.com.devotaku.comicdomain.entity;

import br.com.devotaku.comicdomain.entity.enums.Genre;
import br.com.devotaku.comicdomain.entity.enums.Status;
import br.com.devotaku.comicdomain.entity.value.object.AlternativeName;
import br.com.devotaku.comicdomain.entity.value.object.Author;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.shared.validation.SelfValidation;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public final class Manhwa extends Comic implements SelfValidation<Manhwa> {

    public Manhwa(Identifier id, String title, List<AlternativeName> alternativeNames, List<Author> authors, List<Genre> genres, String description, Status status, Double score) {
        super(id, title, alternativeNames, authors, genres, description, status, score);

        validate(this);
    }

}
