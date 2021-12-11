package br.com.devotaku.comicdomain.entity;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ScoreArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(7.777),
                Arguments.of(7.7777),
                Arguments.of(777.77),
                Arguments.of(7777.77),
                Arguments.of(100.00),
                Arguments.of(-0.01),
                Arguments.of(10.01)
        );
    }

}
