package br.com.devotaku.userservice.utils;

import com.github.javafaker.Faker;

public class PasswordGenerator {

    private static final Faker FAKER = new Faker();

    public static String generateStrongPassword(int minimumLength) {
        return generateStrongPassword(minimumLength, ++minimumLength);
    }

    public static String generateStrongPassword(int minimumLength, int maximumLength) {
        return FAKER
                .internet()
                .password(minimumLength, maximumLength, true, true, true);
    }

    public static String generatePasswordWithoutUppercase(int minimumLength) {
        return generatePasswordWithoutUppercase(minimumLength, ++minimumLength);
    }

    public static String generatePasswordWithoutUppercase(int minimumLength, int maximumLength) {
        return FAKER
                .internet()
                .password(minimumLength, maximumLength, false, true, true);
    }

    public static String generatePasswordWithoutLowercase(int minimumLength) {
        return generatePasswordWithoutLowercase(minimumLength, ++minimumLength);
    }

    public static String generatePasswordWithoutLowercase(int minimumLength, int maximumLength) {
        return FAKER
                .internet()
                .password(minimumLength, maximumLength, true, true, true)
                .toUpperCase();
    }

    public static String generatePasswordWithoutDigits(int minimumLength) {
        return generatePasswordWithoutDigits(minimumLength, ++minimumLength);
    }

    public static String generatePasswordWithoutDigits(int minimumLength, int maximumLength) {
        return FAKER
                .internet()
                .password(minimumLength, maximumLength, true, true, false)
                .toUpperCase();
    }

    public static String generatePasswordWithoutSymbols(int minimumLength) {
        return generatePasswordWithoutSymbols(minimumLength, ++minimumLength);
    }

    public static String generatePasswordWithoutSymbols(int minimumLength, int maximumLength) {
        return FAKER
                .internet()
                .password(minimumLength, maximumLength, true, false, false)
                .toUpperCase();
    }

}
