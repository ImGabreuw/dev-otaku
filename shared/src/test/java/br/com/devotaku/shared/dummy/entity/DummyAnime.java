package br.com.devotaku.shared.dummy.entity;

import br.com.devotaku.shared.validation.SelfValidation;
import lombok.Data;

@Data
public class DummyAnime implements SelfValidation<DummyAnime> {

    private Double score;

    public DummyAnime(Double score) {
        this.score = score;

        validate(this);
    }

}
