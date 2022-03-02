package br.com.devotaku.shared.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

/**
 * @param <V> Value
 */
@AllArgsConstructor(access = PRIVATE)
public class Result<V> {

    @Getter
    private V value;

    private Exception error;

    public static <V> Result<V> failure(Exception error) {
        return new Result<>(null, error);
    }

    public static <V> Result<V> success(V value) {
        return new Result<>(value, null);
    }

    public static <V> Result<V> of(Supplier<V> supplier) {
        try {
            return success(supplier.get());
        } catch (Exception exception) {
            return failure(exception);
        }
    }

    public boolean isSuccess() {
        return error == null;
    }

    public boolean isFailure() {
        return error != null;
    }

}
