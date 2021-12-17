package br.com.devotaku.shared.validation;

import br.com.devotaku.shared.validation.exception.Field;
import br.com.devotaku.shared.validation.exception.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Validar a entidade que implementa a interface {@link SelfValidation}, e em caso de alguma constraint for violada, é lançada uma exceção com o(s) campo(s) violado(s) e suas respectivas mensagens de erro
 *
 * @param <T> A classe da entidade implementada por esta ‘interface’
 * @author ImGabreuw
 */
public interface SelfValidation<T> {

    private static Validator getValidator() {
        return Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    default void validate(T entity) {
        Set<ConstraintViolation<T>> constraintViolations = getValidator().validate(entity);

        if (constraintViolations.isEmpty()) return;

        throw new ValidationException(
                entity,
                constraintViolations.stream()
                        .map(this::binding)
                        .toList()
        );
    }

    private Field binding(ConstraintViolation<T> violation) {
        return new Field(
                violation.getPropertyPath().toString(),
                violation.getMessage(),
                violation.getInvalidValue()
        );
    }

}
