package br.com.devotaku.comicdomain.entity;

import br.com.devotaku.comicdomain.entity.value.object.AlternativeName;
import br.com.devotaku.comicdomain.entity.value.object.Author;
import br.com.devotaku.comicdomain.entity.value.object.Identifier;
import br.com.devotaku.shared.number.NumberHelper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
@Data
public abstract sealed class Comic implements Cloneable, Comparable<Comic> permits Manga, Manhwa, WebToon {

    @NotNull(message = "O campo Id é obrigatório")
    protected Identifier id;

    @NotBlank(message = "O campo Title não pode estar em branco")
    protected String title;

    protected List<AlternativeName> alternativeNames;

    @NotNull(message = "O campo Authors é obrigatório")
    @Size(
            min = 1,
            message = "O campo Authors precisar ter pelo menos 1 autor"
    )
    protected List<Author> authors;

    @NotNull(message = "O campo Genres é obrigatório")
    @Size(
            min = 1,
            message = "O campo Genres precisar ter pelo menos 1 gênero"
    )
    protected List<Genre> genres;

    @NotBlank(message = "O campo Description não pode estar em branco")
    protected String description;

    @NotNull(message = "O campo Title é obrigatório")
    protected Status status;

    @Digits(
            integer = 2,
            fraction = 2,
            message = "O campo Score precisar estar entre 0.00 e 10.00"
    )
    @DecimalMin(
            value = "0.00",
            message = "O campo Score precisar estar entre 0.00 e 10.00"
    )
    @DecimalMax(
            value = "10.00",
            message = "O campo Score precisar estar entre 0.00 e 10.00"
    )
    protected Double score;

    @Setter(PRIVATE)
    protected LocalDate addedAt;

    protected Comic(Identifier id, String title, List<AlternativeName> alternativeNames, List<Author> authors, List<Genre> genres, String description, Status status, Double score) {
        this.id = id;
        this.title = title;
        this.alternativeNames = alternativeNames;
        this.authors = authors;
        this.genres = genres;
        this.description = description;
        this.status = status;
        this.score = score;
        this.addedAt = LocalDate.now();
    }

    @Override
    public Comic clone() {
        try {
            return (Comic) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public boolean hasTitleOrAlternativeNames(String mangaName) {
        return this.title.equalsIgnoreCase(mangaName) ||
                this.alternativeNames.stream().anyMatch(alternativeName -> alternativeName.name().equalsIgnoreCase(mangaName));
    }

    public static <T extends Comic> List<T> generateRandomScore(T baseEntity, long limit) {
        RandomGenerator generator = RandomGenerator.getDefault();

        return Stream.iterate(baseEntity, entity -> {
                    Comic clone = entity.clone();
                    clone.setScore(
                            NumberHelper.formatWith2Digits(generator.nextDouble(10.00))
                    );

                    return (T) clone;
                })
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Comic comic) {
        return Double.compare(getScore(), comic.getScore());
    }

}
