package br.com.devotaku.userservice.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.CharUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PasswordGenerator {

    private static final Faker FAKER = Faker.instance();

    public static String generatePassword(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSymbols, boolean includeDigits) {
        if (includeSymbols) {
            var special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*'};

            var characters = FAKER.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigits);

            while (!(characters.matches("(.*[a-z].*)")
                    || characters.matches("(.*[A-Z].*)")
                    || characters.matches("(.*\\d.*)"))
            ) {
                characters = FAKER.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigits);
            }

            Map<Character, CharInformation> characterAnalysis = new HashMap<>();

            for (int i = 0; i < characters.length(); i++) {
                var character = characters.charAt(i);

                if (CharUtils.toString(characters.charAt(i)).matches("(.*[a-z].*)")) {
                    characterAnalysis.put(
                            character,
                            new CharInformation(CharType.LETTER_IN_LOWERCASE, i)
                    );
                    continue;
                }

                if (CharUtils.toString(characters.charAt(i)).matches("(.*[A-Z].*)")) {
                    characterAnalysis.put(
                            character,
                            new CharInformation(CharType.LETTER_IN_UPPERCASE, i)
                    );
                    continue;
                }

                if (CharUtils.toString(characters.charAt(i)).matches("(.*\\d.*)")) {
                    characterAnalysis.put(
                            character,
                            new CharInformation(CharType.DIGIT, i)
                    );
                }
            }

            List<CharInformation> lowercase = characterAnalysis.values()
                    .stream()
                    .filter(charInformation -> charInformation.type == CharType.LETTER_IN_LOWERCASE)
                    .toList();

            List<CharInformation> uppercase = characterAnalysis.values()
                    .stream()
                    .filter(charInformation -> charInformation.type == CharType.LETTER_IN_UPPERCASE)
                    .toList();

            List<CharInformation> digits = characterAnalysis.values()
                    .stream()
                    .filter(charInformation -> charInformation.type == CharType.DIGIT)
                    .toList();

            Set<Map.Entry<CharType, Integer>> occurrences = Map.of(
                    CharType.LETTER_IN_LOWERCASE, lowercase.size(),
                    CharType.LETTER_IN_UPPERCASE, uppercase.size(),
                    CharType.DIGIT, digits.size()
            ).entrySet();

            char[] password = characters.toCharArray();

            occurrences
                    .stream()
                    .map(Map.Entry::getValue)
                    .max(Integer::compareTo)
                    .ifPresent(moreOccurrence -> {
                        Map.Entry<CharType, Integer> replaceToSymbol = occurrences.stream().filter(entry -> entry.getValue().equals(moreOccurrence)).findFirst().get();

                        switch (replaceToSymbol.getKey()) {
                            case LETTER_IN_LOWERCASE -> {
                                Integer indexReplaceToSymbol = FAKER.random().nextInt(0, lowercase.size() - 1);
                                CharInformation charInformation = lowercase.get(indexReplaceToSymbol);

                                password[charInformation.index()] = special[FAKER.random().nextInt(0, special.length - 1)];
                            }
                            case LETTER_IN_UPPERCASE -> {
                                Integer indexReplaceToSymbol = FAKER.random().nextInt(0, uppercase.size() - 1);
                                CharInformation charInformation = uppercase.get(indexReplaceToSymbol);

                                password[charInformation.index()] = special[FAKER.random().nextInt(0, special.length - 1)];
                            }
                            case DIGIT -> {
                                Integer indexReplaceToSymbol = FAKER.random().nextInt(0, digits.size() - 1);
                                CharInformation charInformation = digits.get(indexReplaceToSymbol);

                                password[charInformation.index()] = special[FAKER.random().nextInt(0, special.length - 1)];
                            }
                        }
                    });


            return new String(password);
        }

        return FAKER.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigits);
    }

    public static String generateStrongPassword(int minimumLength) {
        return generateStrongPassword(minimumLength, ++minimumLength);
    }

    public static String generateStrongPassword(int minimumLength, int maximumLength) {
        return generatePassword(minimumLength, maximumLength, true, true, true);
    }

    public static String generatePasswordWithoutUppercase(int minimumLength) {
        return generatePasswordWithoutUppercase(minimumLength, ++minimumLength);
    }

    public static String generatePasswordWithoutUppercase(int minimumLength, int maximumLength) {
        return generatePassword(minimumLength, maximumLength, false, true, true);
    }

    public static String generatePasswordWithoutLowercase(int minimumLength) {
        return generatePasswordWithoutLowercase(minimumLength, ++minimumLength);
    }

    public static String generatePasswordWithoutLowercase(int minimumLength, int maximumLength) {
        return generatePassword(minimumLength, maximumLength, true, true, true)
                .toUpperCase();
    }

    public static String generatePasswordWithoutDigits(int minimumLength) {
        return generatePasswordWithoutDigits(minimumLength, ++minimumLength);
    }

    public static String generatePasswordWithoutDigits(int minimumLength, int maximumLength) {
        return generatePassword(minimumLength, maximumLength, true, true, false)
                .toUpperCase();
    }

    public static String generatePasswordWithoutSymbols(int minimumLength) {
        return generatePasswordWithoutSymbols(minimumLength, ++minimumLength);
    }

    public static String generatePasswordWithoutSymbols(int minimumLength, int maximumLength) {
        return generatePassword(minimumLength, maximumLength, true, false, true);
    }

    private enum CharType {
        LETTER_IN_LOWERCASE,
        LETTER_IN_UPPERCASE,
        DIGIT,
    }

    private record CharInformation(PasswordGenerator.CharType type, int index) {
    }

}
