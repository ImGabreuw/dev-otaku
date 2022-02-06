package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;
import br.com.devotaku.shared.validation.annotations.Score;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public record AnimeInfoSummary(
        @NotBlank(message = "O campo 'Title' é obrigatório")
        String title,

        @Score
        Double score,

        @NotBlank(message = "O campo 'ImageUrl' é obrigatório")
        @URL(message = "O campo 'ImageUrl' deve conter uma URL válida")
        String imageUrl,

        Progress progress
) implements SelfValidation<AnimeInfoSummary> {

    public AnimeInfoSummary(String title, Double score, String imageUrl, Progress progress) {
        this.title = title;
        this.score = score;
        this.imageUrl = imageUrl;
        this.progress = progress;

        validate(this);
    }

    public static AnimeInfoSummary create(String title, Double score, String imageUri, Integer seen, Integer total) {
        return new AnimeInfoSummary(title, score, imageUri, new Progress(seen, total));
    }

}
