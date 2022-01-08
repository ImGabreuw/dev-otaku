package br.com.devotaku.animedomain.utils.arguments.provider.genre;

import br.com.devotaku.animedomain.utils.arguments.provider.producer.ProducerArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
@ArgumentsSource(GenreArgumentsProvider.class)
public @interface GenreArguments {
}
