package br.com.devotaku.animedomain.utils.arguments.provider.studio;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Set;
import java.util.stream.Stream;

public class StudioArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(new Object[]{null}),
                Arguments.of(Set.of())
        );
    }

}
