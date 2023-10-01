package com.stefanini.module.character.service.impl;

import com.stefanini.module.character.entity.Character;
import com.stefanini.module.character.repository.CharacterRepository;
import com.stefanini.module.character.service.CharacterService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CharacterServiceImpl implements CharacterService {

    CharacterRepository repository;

    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Character> getAllCharacters() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Character createCharacter(Character character) {
        return repository.save(character);
    }
}
