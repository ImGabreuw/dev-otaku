package br.com.devotaku.animedomain.utils.arguments.provider.studio;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
@ArgumentsSource(StudioArgumentsProvider.class)
public @interface StudioArguments {
}
