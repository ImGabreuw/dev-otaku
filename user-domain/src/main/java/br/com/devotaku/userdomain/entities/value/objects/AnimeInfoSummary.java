package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;
import br.com.devotaku.shared.validation.annotations.Score;

import javax.validation.constraints.NotBlank;

public record AnimeInfoSummary(
        @NotBlank(message = "O campo 'Title' é obrigatório")
        String title,

        @Score
        Double score,

        Image image,

        Progress progress
) implements SelfValidation<AnimeInfoSummary> {

    public AnimeInfoSummary(String title, Double score, Image image, Progress progress) {
        this.title = title;
        this.score = score;
        this.image = image;
        this.progress = progress;

        validate(this);
    }

    public static AnimeInfoSummary create(String title, Double score, String imageUrl, Integer seen, Integer total) {
        return new AnimeInfoSummary(title, score, new Image(imageUrl), new Progress(seen, total));
    }

    public String getImageUrl() {
        return image.url();
    }

    public Integer getEpisodesSeen() {
        return progress.seen();
    }

    public Integer getTotalEpisodes() {
        return progress().total();
    }

}
