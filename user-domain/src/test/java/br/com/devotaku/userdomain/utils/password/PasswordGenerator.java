package br.com.devotaku.userdomain.utils.password;

import br.com.devotaku.shared.number.NumberGenerator;
import lombok.NoArgsConstructor;
import org.passay.CharacterRule;

import java.util.List;
import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;
import static org.passay.EnglishCharacterData.*;

@NoArgsConstructor(access = PRIVATE)
public class PasswordGenerator {

    private static final org.passay.PasswordGenerator INSTANCE = new org.passay.PasswordGenerator();

    private static final List<CharacterRule> RULES = List.of(
            new CharacterRule(UpperCase),
            new CharacterRule(LowerCase),
            new CharacterRule(Digit),
            new CharacterRule(Special)
    );

    public static String generate(int length) {
        return INSTANCE.generatePassword(length, RULES);
    }

    public static String generateWithRange(int minLength, int maxLength) {
        return generate(
                NumberGenerator.generateRandomIntegerNumber(minLength, maxLength)
        );
    }

    public static List<String> generatePasswordList(int minLength, int maxLength, int limit) {
        return Stream.generate(() -> PasswordGenerator.generateWithRange(minLength, maxLength))
                .limit(limit)
                .toList();
    }

}
