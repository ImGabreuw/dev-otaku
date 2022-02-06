package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.exception.ValidationException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProgressTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void shouldCreateProgress(int seen) {
        // given
        var total = 26;

        // when
        var underTest = new Progress(seen, total);

        // then
        assertThat(underTest.seen()).isEqualTo(seen);
        assertThat(underTest.total()).isEqualTo(total);
    }

    @Test
    void shouldUpdateProgress() {
        // given
        var seen = 10;
        var total = 26;

        var progress = new Progress(seen, total);

        // when
        var underTest = progress.update(++seen);

        // then
        assertThat(underTest.seen()).isEqualTo(seen);
        assertThat(underTest.total()).isEqualTo(total);
    }

    @Test
    void shouldThrowValidationExceptionWhenCreateProgressBecauseSeenIsInvalid() {
        // given
        var seen = -1;
        var total = 26;

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Progress(seen, total);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Progress teve suas constraints violadas. [Field[fieldName=seen, message=O campo 'Seen' deve conter um número inteiro maior ou igual a 0, value=%s]]",
                        seen
                ));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void shouldThrowValidationExceptionWhenCreateProgressBecauseTotalIsInvalid(int total) {
        // given
        var seen = 10;

        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Progress(seen, total);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Progress teve suas constraints violadas. [Field[fieldName=total, message=O campo 'Total' deve conter um número inteiro maior que 0, value=%s]]",
                        total
                ));
    }

}