package com.sz.rpg.domain.actors;

import com.sz.rpg.domain.features.Feature;

import java.util.List;

/**
 * A base class for every character in the game.
 */
public class Actor {

    private Long id;
    private String name;
    private String description;
    private Party party;
    private List<Feature> availableFeatures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public List<Feature> getAvailableFeatures() {
        return availableFeatures;
    }

    public void setAvailableFeatures(List<Feature> availableFeatures) {
        this.availableFeatures = availableFeatures;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", party=" + party +
                ", availableFeatures=" + availableFeatures +
                '}';
    }
}
