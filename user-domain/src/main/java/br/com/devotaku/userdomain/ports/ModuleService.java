package br.com.devotaku.userdomain.ports;

import br.com.devotaku.userdomain.entities.dtos.DTO;

public sealed interface ModuleService<T extends DTO> permits AnimeModuleService, ComicModuleService {

    T fetch(String title);

}
