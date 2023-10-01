package com.stefanini.module.character.mapping;

import com.stefanini.module.character.dto.CharacterDTO;
import com.stefanini.module.character.entity.Character;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class CharacterDTOToEntityMapping extends MappingConfig {

    public CharacterDTOToEntityMapping(ModelMapper mapper) {
        super(mapper);
    }

    @Override
    public void configure() {
        mapper.createTypeMap(CharacterDTO.class, Character.class);
    }

}
