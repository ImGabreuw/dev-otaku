package br.com.devotaku.shared.validation.annotations;

import br.com.devotaku.shared.dummy.entity.DummyAnime;
import br.com.devotaku.shared.validation.exception.ValidationException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoreAnnotationTest {

    @ParameterizedTest
    @ValueSource(doubles = {0.00, 5.0, 10.00})
    void shouldCreateDummyAnime(Double score) {
        // when
        var underTest = new DummyAnime(score);

        // then
        assertThat(underTest.getScore()).isEqualTo(score);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.01, 10.01})
    void shouldThrowValidationExceptionWhenCreateDummyAnimeBecauseScoreIsInvalid(Double score) {
        // when
        ThrowableAssert.ThrowingCallable underTest = () -> new DummyAnime(score);

        // then
        assertThatThrownBy(underTest)
                .isInstanceOf(ValidationException.class)
                .hasMessage(String.format(
                        "A classe DummyAnime teve suas constraints violadas. [Field[fieldName=score, message=O campo 'Score' deve conter um número entre 0.00 e 10.00, value=%s]]",
                        score
                ));
    }

}

