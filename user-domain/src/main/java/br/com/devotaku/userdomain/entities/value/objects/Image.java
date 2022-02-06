package br.com.devotaku.userdomain.entities.value.objects;

import br.com.devotaku.shared.validation.SelfValidation;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public record Image(
        @NotBlank(message = "O campo 'Url' é obrigatório")
        @URL(
                message = "O campo 'Url' deve conter uma URL válida",
                protocol = "https",
                host = "cdn.myanimelist.net"
        )
        String url
) implements SelfValidation<Image> {

    public Image(String url) {
        this.url = url;

        validate(this);
    }

}
