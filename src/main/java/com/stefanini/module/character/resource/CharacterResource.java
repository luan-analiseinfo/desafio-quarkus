package com.stefanini.module.character.resource;

import com.stefanini.module.character.dto.CharacterDTO;
import com.stefanini.module.character.entity.Character;
import com.stefanini.module.character.service.CharacterService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.modelmapper.ModelMapper;


import java.util.List;


@Path("/characters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CharacterResource {

    CharacterService characterService;
    ModelMapper mapper;

    public CharacterResource(CharacterService characterService, ModelMapper mapper) {
        this.characterService = characterService;
        this.mapper = mapper;
    }

    @GET
    @Operation(summary = "Get all character2s", description = "Get a list of all character2s")
    public List<CharacterDTO> getAllCharacters() {
        return characterService.getAllCharacters().stream().map(o -> mapper.map(o, CharacterDTO.class)).toList();
    }


    @POST
    @Operation(summary = "Create a character", description = "Create a new character")
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200", description = "Character2 created successfully",
                content = @Content(schema = @Schema(implementation = CharacterDTO.class))),
            @APIResponse(responseCode = "400", description = "Invalid input")
        }
    )
    public CharacterDTO createCharacter(@RequestBody @Valid CharacterDTO characterDTO) {
        final var character = characterService.createCharacter(mapper.map(characterDTO, Character.class));
        return mapper.map(character, CharacterDTO.class);
    }

}
