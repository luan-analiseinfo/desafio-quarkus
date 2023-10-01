package com.stefanini.module.character.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CharacterDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Species is required")
    private String species;

    // Other fields with validations...

    private String image;
    private String url;
    private String created;

    @NotNull(message = "Episode is required")
    @Valid
    @JsonProperty("episode")
    private List<String> episodes;

    @NotNull(message = "Origin is required")
    @Valid
    private LocationDTO origin;

    @NotNull(message = "Location is required")
    @Valid
    private LocationDTO location;
}
