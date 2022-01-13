package br.com.devotaku.animedomain.utils.arguments.provider;

import br.com.devotaku.animedomain.utils.arguments.provider.genre.GenreArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
@ArgumentsSource(AnimeNameArgumentsProvider.class)
public @interface AnimeNameArguments {
}
