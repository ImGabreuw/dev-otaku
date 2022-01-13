package br.com.devotaku.animedomain.entity.value.object;

import br.com.devotaku.animedomain.utils.NullEmptyAndBlankSource;
import br.com.devotaku.shared.validation.exception.ValidationException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StudioTest {

    @Test
    void shouldCreateStudio() {
        // given
        String name = "MAPPA";

        // when
        Studio underTest = new Studio(name);

        // then
        assertThat(underTest.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowValidationExceptionWhenCreateStudioBecauseNameIsInvalid(String name) {
        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Studio(name);

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }
}