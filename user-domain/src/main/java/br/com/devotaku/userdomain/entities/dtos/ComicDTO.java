package br.com.devotaku.userdomain.entities.dtos;

public record ComicDTO(
        String imageUrl,
        String title,
        Double score,
        Integer readChapters,
        Integer totalChapters
) implements DTO {
}
