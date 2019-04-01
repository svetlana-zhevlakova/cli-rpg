package com.sz.rpg.domain.features;

/**
 * A class that represents abilities and equipment of the character, i.e. extra power, regeneration, weapon, armor
 */
public class Feature {

    private String name;
    private FeatureType featureType;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
