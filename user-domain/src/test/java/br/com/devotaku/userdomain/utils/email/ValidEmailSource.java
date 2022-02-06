package br.com.devotaku.userdomain.utils.email;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
@ArgumentsSource(ValidEmailArgumentsProvider.class)
public @interface ValidEmailSource {

    /**
     * The limit number of valid emails that need to be provided
     */
    int limit() default 18;

}
