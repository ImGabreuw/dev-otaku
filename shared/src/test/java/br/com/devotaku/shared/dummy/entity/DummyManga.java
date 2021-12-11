package br.com.devotaku.shared.dummy.entity;

import br.com.devotaku.shared.validation.SelfValidation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class DummyManga implements SelfValidation<DummyManga> {

    @NotBlank
    private String title;

    @Positive
    private Integer chapters;

    public DummyManga(String title, Integer chapters) {
        this.title = title;
        this.chapters = chapters;

        validate(this);
    }

}
