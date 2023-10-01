package com.stefanini.module.character.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "character_tb")
@Data
public class Character extends PanacheEntity {

    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public String image;
    public String url;
    public String created;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Location origin;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Location location;

    @ElementCollection
    public List<String> episodes;


}
