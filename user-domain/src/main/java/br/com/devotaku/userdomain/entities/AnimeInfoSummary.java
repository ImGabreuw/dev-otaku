package br.com.devotaku.userdomain.entities;

import br.com.devotaku.shared.validation.SelfValidation;
import br.com.devotaku.userdomain.entities.value.objects.Image;
import br.com.devotaku.userdomain.entities.value.objects.Progress;
import br.com.devotaku.userdomain.entities.value.objects.Score;
import br.com.devotaku.userdomain.entities.value.objects.Title;
import lombok.Data;

@Data
public class AnimeInfoSummary implements SelfValidation<AnimeInfoSummary> {

    private Title title;

    private Score score;

    private Image image;

    private Progress progress;

    public AnimeInfoSummary(Title title, Score score, Image image, Progress progress) {
        this.title = title;
        this.score = score;
        this.image = image;
        this.progress = progress;

        validate(this);
    }

    public static AnimeInfoSummary create(String title, Double score, String imageUrl, Integer seen, Integer total) {
        return new AnimeInfoSummary(
                new Title(title),
                new Score(score),
                new Image(imageUrl),
                new Progress(seen, total)
        );
    }

    public String getTitle() {
        return title.value();
    }

    public Double getScore() {
        return score.value();
    }

    public String getImageUrl() {
        return image.url();
    }

    public Integer getEpisodesSeen() {
        return progress.seen();
    }

    public Integer getTotalEpisodes() {
        return progress.total();
    }

}
