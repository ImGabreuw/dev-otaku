package br.com.devotaku.userdomain.entities;

import br.com.devotaku.shared.validation.SelfValidation;
import br.com.devotaku.userdomain.entities.exceptions.LoginException;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

@Data
public class Login implements SelfValidation<Login> {

    @NotBlank(message = "O campo 'Email' não deve estar em branco")
    @Email(message = "O campo 'Email' deve conter um email válido")
    @Setter(PRIVATE)
    private String email;

    @NotNull(message = "O campo 'Password' é obrigatório")
    @Size(min = 5, max = 20, message = "O campo 'Password' deve conter um valor de tamanho de {1} a {2} caracteres")
    @Setter(PRIVATE)
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;

        validate(this);
    }

    public void changePassword(String newPassword) {
        if (this.password.equals(newPassword)) {
            throw new LoginException("As senhas são iguais.");
        }

        this.password = newPassword;
    }

}
