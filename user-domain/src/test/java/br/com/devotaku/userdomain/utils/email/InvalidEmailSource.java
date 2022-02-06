package br.com.devotaku.userdomain.utils.email;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
@ArgumentsSource(InvalidEmailArgumentsProvider.class)
public @interface InvalidEmailSource {

    /**
     * The limit number of invalid emails that need to be provided
     */
    int limit() default 15;

}
