package br.com.devotaku.animeservice.domain.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Month;
import java.util.Arrays;

import static java.time.Month.*;

@RequiredArgsConstructor
public enum Season {

    WINTER("winter season", JANUARY, MARCH) {
        @Override
        public Month[] getSeasonMonths() {
            return Arrays.stream(Month.values())
                    .filter(month -> month.getValue() >= WINTER.start.getValue() && month.getValue() <= WINTER.end.getValue())
                    .toArray(Month[]::new);
        }

        @Override
        public Integer[] getValueOfSeasonMonths() {
            return Arrays.stream(WINTER.getSeasonMonths())
                    .map(Month::getValue)
                    .toArray(Integer[]::new);
        }
    },
    SPRING("spring season", APRIL, JUNE) {
        @Override
        public Month[] getSeasonMonths() {
            return Arrays.stream(Month.values())
                    .filter(month -> month.getValue() >= SPRING.start.getValue() && month.getValue() <= SPRING.end.getValue())
                    .toArray(Month[]::new);
        }

        @Override
        public Integer[] getValueOfSeasonMonths() {
            return Arrays.stream(SPRING.getSeasonMonths())
                    .map(Month::getValue)
                    .toArray(Integer[]::new);
        }
    },
    SUMMER("summer season", JULY, SEPTEMBER) {
        @Override
        public Month[] getSeasonMonths() {
            return Arrays.stream(Month.values())
                    .filter(month -> month.getValue() >= SUMMER.start.getValue() && month.getValue() <= SUMMER.end.getValue())
                    .toArray(Month[]::new);
        }

        @Override
        public Integer[] getValueOfSeasonMonths() {
            return Arrays.stream(WINTER.getSeasonMonths())
                    .map(Month::getValue)
                    .toArray(Integer[]::new);
        }
    },
    FALL("fall season", OCTOBER, DECEMBER) {
        @Override
        public Month[] getSeasonMonths() {
            return Arrays.stream(Month.values())
                    .filter(month -> month.getValue() >= FALL.start.getValue() && month.getValue() <= FALL.end.getValue())
                    .toArray(Month[]::new);
        }

        @Override
        public Integer[] getValueOfSeasonMonths() {
            return Arrays.stream(WINTER.getSeasonMonths())
                    .map(Month::getValue)
                    .toArray(Integer[]::new);
        }
    };

    @Getter
    private final String description;
    private final Month start;
    private final Month end;

    public abstract Month[] getSeasonMonths();

    public abstract Integer[] getValueOfSeasonMonths();

}
