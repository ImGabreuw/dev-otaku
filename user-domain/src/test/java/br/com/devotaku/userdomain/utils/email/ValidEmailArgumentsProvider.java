package br.com.devotaku.userdomain.utils.email;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.stream.Stream;

import static br.com.devotaku.userdomain.utils.email.EmailUtils.VALID_EMAILS;

public class ValidEmailArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<ValidEmailSource> {

    private int limit;

    @Override
    public void accept(ValidEmailSource validEmailArguments) {
        limit = validEmailArguments.limit();
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return VALID_EMAILS
                .stream()
                .limit(limit)
                .map(Arguments::of);
    }

}