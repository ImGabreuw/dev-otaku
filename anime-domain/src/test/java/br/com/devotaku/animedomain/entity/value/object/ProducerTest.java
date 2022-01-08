package br.com.devotaku.animedomain.entity.value.object;

import br.com.devotaku.animedomain.utils.NullEmptyAndBlankSource;
import br.com.devotaku.shared.validation.exception.ValidationException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProducerTest {

    @Test
    void shouldCreateProducer() {
        // given
        String name = "Mainichi Broadcasting System";

        // when
        Producer underTest = new Producer(name);

        // then
        assertThat(underTest.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullEmptyAndBlankSource
    void shouldThrowValidationExceptionWhenCreateProducerBecauseNameIsInvalid(String name) {
        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new Producer(name);

        // then
        assertThatThrownBy(underTest).isInstanceOf(ValidationException.class);
    }

}