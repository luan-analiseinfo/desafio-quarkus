package com.stefanini.module.character.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Episode extends PanacheEntity {

    public String name;
    public String airDate;
    public String episode;

    public String url;
    public String created;

    @OneToMany(fetch = FetchType.LAZY)
    public List<Character> characters;

}
