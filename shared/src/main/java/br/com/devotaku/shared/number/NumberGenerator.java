package br.com.devotaku.shared.number;

import lombok.NoArgsConstructor;

import java.util.random.RandomGenerator;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class NumberGenerator {

    /**
     *
     * @param start The start value of the interval (included)
     * @param end The end value of the interval (included)
     * @return A random integer number between the specific interval
     */
    public static int generateRandomIntegerNumber(int start, int end) {
        return RandomGenerator
                .getDefault()
                .nextInt(start, ++end);
    }

}
