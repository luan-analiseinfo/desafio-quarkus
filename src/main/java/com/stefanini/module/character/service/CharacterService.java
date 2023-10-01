package com.stefanini.module.character.service;


import com.stefanini.module.character.entity.Character;

import java.util.List;


public interface CharacterService {
    List<Character> getAllCharacters();
    Character createCharacter(Character character);
    // Outros métodos de serviço para personagens
}
