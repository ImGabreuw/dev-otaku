package br.com.devotaku.shared.reflection;

import br.com.devotaku.shared.dummy.entity.DummyManga;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReflectionHelperTest {

    @Test
    void shouldValidateNonExistentField() {
        // given
        Class<DummyManga> entity = DummyManga.class;
        String fieldName = "titleeeee";

        // when
        ThrowableAssert.ThrowingCallable underTestReflectionHelper = () -> ReflectionHelper.validateFieldName(entity, fieldName);

        // then
        assertThatThrownBy(underTestReflectionHelper)
                .isInstanceOf(NoSuchFieldException.class)
                .hasMessage(String.format(
                        "Não existe nenhum campo com o nome [%s] na entidade [%s]",
                        fieldName, entity.getSimpleName()
                ));
    }

}