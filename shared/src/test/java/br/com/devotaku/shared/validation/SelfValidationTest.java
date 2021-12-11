package br.com.devotaku.shared.validation;

import br.com.devotaku.shared.dummy.entity.DummyManga;
import br.com.devotaku.shared.validation.exception.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SelfValidationTest {

    @Test
    void shouldThrowValidationExceptionBecauseNameIsNull() {
        // given
        String title = null;
        int chapters = 1000;

        // when, then
        Assertions.assertThatThrownBy(() -> new DummyManga(title, chapters))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(DummyManga.class.getSimpleName())
                .hasMessageContaining("fieldName=title")
                .hasMessageContaining("value=" + title);
    }

    @Test
    void shouldThrowValidationExceptionBecauseAgeIsNegative() {
        // given
        String title = "One Piece";
        int chapters = -1;

        // when, then
        Assertions.assertThatThrownBy(() -> new DummyManga(title, chapters))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(DummyManga.class.getSimpleName())
                .hasMessageContaining("fieldName=chapters")
                .hasMessageContaining("value=" + chapters);
    }

}

