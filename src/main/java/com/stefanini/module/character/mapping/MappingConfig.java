package com.stefanini.module.character.mapping;

import org.modelmapper.ModelMapper;

public abstract class MappingConfig {

    ModelMapper mapper;

    public MappingConfig(ModelMapper mapper) {
        this.mapper = mapper;
    }

  abstract void configure();
}
