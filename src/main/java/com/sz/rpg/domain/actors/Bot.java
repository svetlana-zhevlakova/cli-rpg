package com.sz.rpg.domain.actors;

import com.sz.rpg.domain.features.Feature;

import java.util.List;

public class Bot extends Actor {

    @Override
    public String toString() {
        return "Bot{" +
                "name='" + getName() + '\'' +
                ", party=" + getParty() +
                ", availableFeatures=" + getAvailableFeatures() +
                '}';
    }
}
