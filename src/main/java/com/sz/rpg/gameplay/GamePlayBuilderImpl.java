package com.sz.rpg.gameplay;

import com.sz.rpg.domain.gameplay.Game;
import com.sz.rpg.domain.actors.Player;
import com.sz.rpg.domain.gameplay.PlayGrid;

public class GamePlayBuilderImpl implements GamePlayBuilder {
    private Game tmpGame;

    public GamePlayBuilderImpl() {
        this.tmpGame = new Game();
    }

/*    @Override
    public GamePlayBuilder setPlayer(Player player) {
        tmpGame.setPlayer(player);
        return this;
    }

    @Override
    public GamePlayBuilder setPlayGrid(PlayGrid playGrid){
        tmpGame.setPlayGrid(playGrid);
        return this;
    }

    @Override
    public Game build(){
        Game game = new Game();
        game.setPlayer(tmpGame.getPlayer());
        game.setPlayGrid(tmpGame.getPlayGrid());
        return game;
    }*/
}
