package br.com.devotaku.userdomain.utils.password;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.stream.Stream;

public class ValidPasswordArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<ValidPasswordSource> {

    private int length;

    @Override
    public void accept(ValidPasswordSource validPasswordSource) {
        length = validPasswordSource.length();
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(PasswordGenerator.generate(length))
        );
    }

}