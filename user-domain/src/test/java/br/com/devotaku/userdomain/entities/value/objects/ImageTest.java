package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ImageTest {

    @Test
    void shouldCreateImage() {
        // given
        var imageUrl = "https://cdn.myanimelist.net/images/manga/1/157897.jpg";

        // when
        var underTest = new Image(imageUrl);

        // then
        assertThat(underTest.url()).isEqualTo(imageUrl);
    }

    @Test
    void shouldThrowValidationExceptionWhenCreateImageBecauseImageUrlHasInvalidProtocol() {
        // given
        var imageUrl = "http://cdn.myanimelist.net/images/manga/1/157897.jpg";

        // when, then
        assertThatThrownBy(() -> new Image(imageUrl))
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Image teve suas constraints violadas. [Field[fieldName=url, message=O campo 'Url' deve conter uma URL válida, value=%s]]",
                        imageUrl
                ));
    }

    @Test
    void shouldThrowValidationExceptionWhenCreateImageBecauseImageUrlHasInvalidHost() {
        // given
        var imageUrl = "https://my-host.com/images/manga/1/157897.jpg";

        // when, then
        assertThatThrownBy(() -> new Image(imageUrl))
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Image teve suas constraints violadas. [Field[fieldName=url, message=O campo 'Url' deve conter uma URL válida, value=%s]]",
                        imageUrl
                ));
    }

}