package com.sz.rpg.domain.actors;

public class Player extends Actor {

    private double experience;

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public void updateExperience(double extraExperience){
        experience = experience + extraExperience;
    }
}
