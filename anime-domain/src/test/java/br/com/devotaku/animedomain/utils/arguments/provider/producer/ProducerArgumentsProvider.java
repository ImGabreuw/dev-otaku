package br.com.devotaku.animedomain.utils.arguments.provider.producer;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Set;
import java.util.stream.Stream;

public class ProducerArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new Object[]{null}),
                Arguments.of(Set.of())
        );
    }

}
