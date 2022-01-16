package br.com.devotaku.comicdomain.entity.value.object;

import br.com.devotaku.comicdomain.utils.NullEmptyAndBlankSource;
import br.com.devotaku.shared.validation.exception.ValidationException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AlternativeNameTest {

    @Test
    void shouldCreateAlternativeName() {
        // given
        var value = "ONE PIECE";

        // when
        var underTest = new AlternativeName(value);

        // then
        assertThat(underTest.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowValidationExceptionWhenCreateAlternativeNameBecauseInputIsInvalid(String value) {
        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new AlternativeName(value);

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }
}