package com.stefanini.module.character.mapping;

import com.stefanini.module.character.dto.CharacterDTO;
import com.stefanini.module.character.entity.Character;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class CharacterToDTOMapping extends MappingConfig {

    public CharacterToDTOMapping(ModelMapper mapper) {
        super(mapper);
    }

    @Override
    public void configure() {
        mapper.createTypeMap(Character.class, CharacterDTO.class);
    }

}
