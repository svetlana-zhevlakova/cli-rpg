package com.sz.rpg.domain.gameplay;

import com.sz.rpg.domain.actors.Actor;
import com.sz.rpg.domain.actors.Bot;
import com.sz.rpg.domain.actors.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String title;
    private List<PlayGrid> playGrid;
    private List<Player> players = new ArrayList<Player>();
    private List<Bot> bots = new ArrayList<Bot>();
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Bot> getBots() {
        return bots;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
