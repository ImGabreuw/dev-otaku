package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.userdomain.entities.ComicInfoSummary;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComicInfoSummaryTest {

    @Test
    void shouldCreateComicInfoSummary() {
        // given
        var title = "Berserk";
        var score = 9.43;
        var imageUrl = "https://cdn.myanimelist.net/images/manga/1/157897.jpg";
        var chaptersSeen = 230;
        var totalChapters = 380;

        // when
        var underTest = ComicInfoSummary.create(title, score, imageUrl, chaptersSeen, totalChapters);

        // then
        assertThat(underTest.getTitle()).isEqualTo(title);
        assertThat(underTest.getScore()).isEqualTo(score);
        assertThat(underTest.getImageUrl()).isEqualTo(imageUrl);
        assertThat(underTest.getChaptersSeen()).isEqualTo(chaptersSeen);
        assertThat(underTest.getTotalChapters()).isEqualTo(totalChapters);
    }
}