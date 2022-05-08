package br.com.devotaku.animeservice.application.config.mapper.annotations;

import org.mapstruct.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

@Qualifier
@Target(METHOD)
@Retention(CLASS)
public @interface ToDomain {
}
