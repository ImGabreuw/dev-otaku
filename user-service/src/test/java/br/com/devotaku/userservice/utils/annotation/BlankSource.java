package br.com.devotaku.userservice.utils.annotation;

import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
@NullAndEmptySource
@ValueSource(strings = "   ")
public @interface BlankSource {
}
