package com.sz.rpg.domain.actors;

import com.sz.rpg.domain.features.Feature;

import java.util.List;

/**
 * A base class for every character in the game.
 */
public class Actor {
    private String name;
    private String description;
    private boolean canPlay;
    private List<Feature> availableFeatures;

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

    public boolean isCanPlay() {
        return canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public List<Feature> getAvailableFeatures() {
        return availableFeatures;
    }

    public void setAvailableFeatures(List<Feature> availableFeatures) {
        this.availableFeatures = availableFeatures;
    }
}
