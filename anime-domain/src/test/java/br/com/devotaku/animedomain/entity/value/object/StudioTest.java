package br.com.devotaku.animedomain.entity.value.object;

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
        Studio underTestStudio = new Studio(name);

        // then
        assertThat(underTestStudio.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   "})
    void shouldThrowValidationExceptionWhenCreateStudioBecauseNameIsInvalid(String name) {
        // when
        ThrowableAssert.ThrowingCallable underTestStudio = () -> new Studio(name);

        // then
        assertThatThrownBy(underTestStudio)
                .isInstanceOf(ValidationException.class);
    }
}