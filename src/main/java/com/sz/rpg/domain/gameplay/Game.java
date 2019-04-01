package com.sz.rpg.domain.gameplay;

import com.sz.rpg.domain.actors.Actor;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String title;
    private List<PlayGrid> playGrid;
    private List<Actor> actors = new ArrayList<Actor>();
    private List<Action> actions = new ArrayList<Action>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PlayGrid> getPlayGrid() {
        return playGrid;
    }

    public void setPlayGrid(List<PlayGrid> playGrid) {
        this.playGrid = playGrid;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
