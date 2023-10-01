package com.stefanini.module.character.repository.impl;

import com.stefanini.module.character.entity.Character;
import com.stefanini.module.character.repository.CharacterRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class CharacterRepositoryImpl implements CharacterRepository {

    @Override
    public Character save(Character character) {
         character.persist();
        return character;
    }

    @Override
    public List<Character> findAll() {
        return Character.findAll().list();
    }
}
