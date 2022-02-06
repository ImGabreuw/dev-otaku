package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;
import br.com.devotaku.shared.validation.annotations.Score;

import javax.validation.constraints.NotBlank;

public record ComicInfoSummary(
        @NotBlank(message = "O campo 'Title' é obrigatório")
        String title,

        @Score
        Double score,

        Image image,

        Progress progress
) implements SelfValidation<ComicInfoSummary> {

    public ComicInfoSummary(String title, Double score, Image image, Progress progress) {
        this.title = title;
        this.score = score;
        this.image = image;
        this.progress = progress;

        validate(this);
    }

    public static ComicInfoSummary create(String title, Double score, String imageUrl, Integer seen, Integer total) {
        return new ComicInfoSummary(title, score, new Image(imageUrl), new Progress(seen, total));
    }

    public String getImageUrl() {
        return image.url();
    }

    public Integer getChaptersSeen() {
        return progress.seen();
    }

    public Integer getTotalChapters() {
        return progress().total();
    }

}
