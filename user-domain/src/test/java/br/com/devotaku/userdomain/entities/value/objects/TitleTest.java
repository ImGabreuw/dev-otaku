package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.exception.ValidationException;
import br.com.devotaku.userdomain.utils.NullEmptyAndBlankSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TitleTest {

    @Test
    void shouldCreateTitle() {
        // given
        var title = "Fullmetal Alchemist: Brotherhood";

        // when
        var underTest = new Title(title);

        // then
        assertThat(underTest.value()).isEqualTo(title);
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowValidationExceptionWhenCreateTitle(String title) {
        // when, then
        assertThatThrownBy(() -> new Title(title))
                .isInstanceOf(ValidationException.class);
    }
}