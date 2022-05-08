package br.com.devotaku.animeservice.application.config.mapper.annotations.identifier;

import org.mapstruct.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

@Qualifier
@Target(TYPE)
@Retention(CLASS)
public @interface IdentifierMapper {
}
