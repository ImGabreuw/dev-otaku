package br.com.devotaku.shared.number;

import lombok.NoArgsConstructor;

import java.util.Locale;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class NumberHelper {

    static {
        Locale.setDefault(Locale.US);
    }

    public static Double formatWith2Digits(Double number) {
        return Double.parseDouble(
                String.format("%.2f", number)
        );
    }

}
