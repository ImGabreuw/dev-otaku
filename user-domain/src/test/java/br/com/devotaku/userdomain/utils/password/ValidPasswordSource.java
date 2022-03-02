package br.com.devotaku.userdomain.utils.password;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
@ArgumentsSource(ValidPasswordArgumentsProvider.class)
public @interface ValidPasswordSource {

    /**
     * The max length of the password
     */
    int length() default 12;

}
