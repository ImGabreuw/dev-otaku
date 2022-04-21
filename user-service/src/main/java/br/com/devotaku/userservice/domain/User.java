package br.com.devotaku.userservice.domain;

import br.com.devotaku.userservice.domain.value.objects.Email;
import br.com.devotaku.userservice.domain.value.objects.Name;
import br.com.devotaku.userservice.domain.value.objects.Password;
import br.com.devotaku.userservice.domain.value.objects.Username;
import br.com.devotaku.userservice.shared.validation.SelfValidation;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
public class User implements SelfValidation<User> {

    private Name name;

    private Username username;

    private Email email;

    private Password password;

    public User(Name name, Username username, Email email, Password password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;

        validate(this);
    }
}
