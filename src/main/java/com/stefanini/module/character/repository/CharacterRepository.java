package com.stefanini.module.character.repository;

import com.stefanini.module.character.entity.Character;

import java.util.List;

public interface CharacterRepository {
    Character save(Character character);

    List<Character> findAll();
}
