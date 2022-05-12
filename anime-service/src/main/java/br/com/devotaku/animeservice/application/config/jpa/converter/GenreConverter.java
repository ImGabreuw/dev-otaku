package br.com.devotaku.animeservice.application.config.jpa.converter;

import br.com.devotaku.animeservice.domain.entities.enums.Genre;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@Converter(autoApply = true)
public class GenreConverter implements AttributeConverter<List<Genre>, String> {

    @Override
    public String convertToDatabaseColumn(List<Genre> attribute) {
        return Genre.convertGenresToString(attribute);
    }

    @Override
    public List<Genre> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(","))
                .map(Genre::valueOf)
                .collect(Collectors.toList());
    }

}
