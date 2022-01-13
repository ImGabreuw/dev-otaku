package br.com.devotaku.animedomain.utils.arguments.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class AnimeNameArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("Jujutsu Kaisen"),
                Arguments.of("呪術廻戦"),
                Arguments.of("Sorcery Fight")
        );
    }

}
