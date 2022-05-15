package br.com.devotaku.animeservice.shared.helper;

import com.github.javafaker.Faker;

public class RandomHelper {

    private static final Faker FAKER = Faker.instance();

    /**
     * Return a number between <i>min</i> and <i>max</i>. If <code>min == max</code>, then <i>min</i> is returned.
     *
     * @param min inclusive
     * @param max inclusive
     */
    public static long number(long min, long max) {
        return FAKER.number().numberBetween(min, ++max);
    }

}
