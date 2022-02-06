package br.com.devotaku.userdomain.entities;

import br.com.devotaku.shared.validation.SelfValidation;
import br.com.devotaku.userdomain.entities.value.objects.AnimeInfoSummary;
import br.com.devotaku.userdomain.entities.value.objects.ComicInfoSummary;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class User implements SelfValidation<User> {

    @NotBlank(message = "O campo 'Name' não pode estar em branco")
    private String name;

    @NotNull(message = "O campo 'Login' é obrigatório")
    @Email(message = "O campo 'Email' deve conter um email válido")
    private String email;

    @NotNull(message = "O campo 'ComicStats' é obrigatório")
    private ComicStats comicStats;

    @NotNull(message = "O campo 'AnimeStats' é obrigatório")
    private AnimeStats animeStats;

    private final Set<ComicInfoSummary> comicHistory = new HashSet<>();

    private final Set<AnimeInfoSummary> animeHistory = new HashSet<>();

    public User(String name, String email, ComicStats comicStats, AnimeStats animeStats) {
        this.name = name;
        this.email = email;
        this.comicStats = comicStats;
        this.animeStats = animeStats;

        validate(this);
    }

    public static User create(String name, String email) {
        return new User(
                name,
                email,
                new ComicStats(),
                new AnimeStats()
        );
    }

}
