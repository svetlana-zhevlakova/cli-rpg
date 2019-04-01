package com.sz.rpg.main;

import com.sz.rpg.domain.actors.Player;
import com.sz.rpg.domain.gameplay.Game;
import com.sz.rpg.utils.JSONDeserializerUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {

        System.out.println("Welcome to the Game...\n1. Start new game\n2. Resume\n3. Exit");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        System.out.println(action);
        if ("1".equals(action)) {

            Game game = new Game();
            // TODO -> GameBuilder
            System.out.println("Select a map:\n1. Blade Runner\n2. Ghost in the Shell\n3. Lord of The Rings");
            String gameMap = scanner.nextLine();
            if ("1".equals(gameMap)) {
                game = JSONDeserializerUtil.deserialize(Main.class.getResourceAsStream("/games/game.json"));
            } else if ("2".equals(gameMap)) {
                System.out.println("Not implemented yet");
            } else if ("3".equals(gameMap)) {
                System.out.println("Not implemented yet");
            } else {
                System.out.println("Unavailable option");
            }

            System.out.println("Create your character:");
            //TODO build a character from the preset attributes
            Player player = new Player();

            /*Thread thread = new Thread(new Game());
            thread.start();*/
        } else if ("2".equals(action)) {
            //read from file and start game
        } else if ("3".equals(action)) {
            System.exit(0);
        } else {
            System.out.println("Unavailable option");
        }


    }
}
