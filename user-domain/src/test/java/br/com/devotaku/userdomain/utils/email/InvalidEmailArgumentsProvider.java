package br.com.devotaku.userdomain.utils.email;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.stream.Stream;

import static br.com.devotaku.userdomain.utils.email.EmailUtils.INVALID_EMAILS;

public class InvalidEmailArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<InvalidEmailSource> {

    private int limit;

    @Override
    public void accept(InvalidEmailSource invalidEmailArguments) {
        limit = invalidEmailArguments.limit();
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return INVALID_EMAILS
                .stream()
                .limit(limit)
                .map(Arguments::of);
    }

}
