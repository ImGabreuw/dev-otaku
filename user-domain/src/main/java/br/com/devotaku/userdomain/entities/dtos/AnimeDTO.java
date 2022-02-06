package br.com.devotaku.userdomain.entities.dtos;

public record AnimeDTO(
        String imageUrl,
        String title,
        Double score,
        Integer watchedEpisodes,
        Integer totalEpisodes
) implements DTO {
}
