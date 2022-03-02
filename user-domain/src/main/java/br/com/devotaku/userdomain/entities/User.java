package br.com.devotaku.userdomain.entities;

import br.com.devotaku.shared.validation.SelfValidation;
import br.com.devotaku.userdomain.entities.value.objects.Email;
import br.com.devotaku.userdomain.entities.value.objects.Name;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class User implements SelfValidation<User> {

    private Name name;

    private Email email;

    @NotNull(message = "O campo 'ComicStats' é obrigatório")
    private ComicStats comicStats;

    @NotNull(message = "O campo 'AnimeStats' é obrigatório")
    private AnimeStats animeStats;

    private final Set<ComicInfoSummary> comicHistory = new HashSet<>();

    private final Set<AnimeInfoSummary> animeHistory = new HashSet<>();

    public User(Name name, Email email, ComicStats comicStats, AnimeStats animeStats) {
        this.name = name;
        this.email = email;
        this.comicStats = comicStats;
        this.animeStats = animeStats;

        validate(this);
    }

    public static User create(String name, String email) {
        return new User(
                new Name(name),
                new Email(email),
                new ComicStats(),
                new AnimeStats()
        );
    }

}
