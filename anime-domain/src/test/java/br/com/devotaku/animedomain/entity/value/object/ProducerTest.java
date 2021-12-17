package br.com.devotaku.animedomain.entity.value.object;

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
        Producer underTestProducer = new Producer(name);

        // then
        assertThat(underTestProducer.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "   ")
    void shouldThrowValidationExceptionWhenCreateProducerBecauseNameIsInvalid(String name) {
        // when
        ThrowableAssert.ThrowingCallable underTestProducer = () -> new Producer(name);

        // then
        assertThatThrownBy(underTestProducer)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe Producer teve suas constraints violadas. [Field[fieldName=name, message=não deve estar em branco, value=%s]]",
                        name
                ));
    }

}