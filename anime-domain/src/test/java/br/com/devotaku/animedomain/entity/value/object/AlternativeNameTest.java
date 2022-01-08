package br.com.devotaku.animedomain.entity.value.object;

import br.com.devotaku.animedomain.utils.NullEmptyAndBlankSource;
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
        String name = "Sorcery Fight";

        // when
        AlternativeName underTest = new AlternativeName(name);

        // then
        assertThat(underTest.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowValidationExceptionWhenCreateAlternativeNameBecauseNameIsInvalid(String name) {
        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new AlternativeName(name);

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

}