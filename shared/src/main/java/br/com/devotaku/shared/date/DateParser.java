package br.com.devotaku.shared.date;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DateParser {

    public static LocalDate parse(String source) {
        return LocalDate.parse(source, ISO_LOCAL_DATE);
    }

}
