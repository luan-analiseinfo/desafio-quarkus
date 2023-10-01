package com.stefanini.module.character.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Air date is required")
    private String airDate;

    @NotBlank(message = "Episode is required")
    private String episode;

    // Other fields with validations...

    private String url;
    private String created;

    @NotNull(message = "Characters list is required")
    @Valid
    private List<CharacterDTO> characters;
}
