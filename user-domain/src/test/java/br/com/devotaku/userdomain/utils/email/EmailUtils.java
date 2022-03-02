package br.com.devotaku.userdomain.utils.email;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class EmailUtils {

    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    public static final List<String> INVALID_EMAILS = Arrays.asList(
            "plainaddress",
            "#@%^%#$@#$@#.com",
            "@example.com",
            "Joe Smith <email@example.com>",
            "email.example.com",
            "email@example@example.com",
            ".email@example.com",
            "email.@example.com",
            "email..email@example.com",
            "email@example.com (Joe Smith)",
            "email@-example.com",
            "email@example..com",
            "Abc..123@example.com",
            "”(),:;<>[\\]@example.com",
            "this\\ is\"really\"not\\allowed@example.com"
    );

    public static final List<String> VALID_EMAILS = Arrays.asList(
            "email@example.com",
            "firstname.lastname@example.com",
            "email@subdomain.example.com",
            "firstname+lastname@example.com",
            "email@123.123.123.123",
            "email@[123.123.123.123]",
            "\"email\"@example.com",
            "1234567890@example.com",
            "email@example-one.com",
            "_______@example.com",
            "email@example.value",
            "email@example.museum",
            "email@example.co.jp",
            "あいうえお@example.com",
            "email@example",
            "email@example.web",
            "email@111.222.333.44444",
            "just”not”right@example.com"
    );

    public static String getRandomEmail(List<String> emails) {
        int randomIndex = RANDOM_GENERATOR.nextInt(0, emails.size() - 1);

        return emails.get(randomIndex);
    }

    public static String getRandomInvalidEmail() {
        return getRandomEmail(INVALID_EMAILS);
    }

    public static String getRandomValidEmail() {
        return getRandomEmail(VALID_EMAILS);
    }

}
