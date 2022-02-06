package br.com.devotaku.userdomain.utils.login;

import br.com.devotaku.userdomain.utils.password.PasswordGenerator;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static br.com.devotaku.userdomain.utils.email.EmailUtils.VALID_EMAILS;

public class LoginArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        List<Arguments> arguments = new ArrayList<>();

        var passwordList = PasswordGenerator.generatePasswordList(5, 20, VALID_EMAILS.size());

        for (int i = 0; i < VALID_EMAILS.size(); i++) {
            arguments.add(Arguments.of(
                    VALID_EMAILS.get(i),
                    passwordList.get(i)
            ));
        }

        return arguments.stream();
    }

}
