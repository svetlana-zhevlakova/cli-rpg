package com.sz.rpg.main;

import com.sz.rpg.domain.actors.Player;
import com.sz.rpg.domain.gameplay.Game;
import com.sz.rpg.gameplay.GameLoop;
import com.sz.rpg.utils.JSONDeserializerUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        start();
    }

    private static void start() {
        System.out.println("Welcome to the Game...\n1. Start new game\n2. Resume\n3. Exit");
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            if ("1".equals(action)) {
                gameSetup(scanner);
            } else if ("2".equals(action)) {
                //read from file and start game
            } else if ("3".equals(action)) {
                System.exit(0);
            } else {
                System.out.println("Unavailable option");
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void gameSetup(Scanner scanner) {
        InputStream gamesInputStream = getResource("/games/games_list.json");
        Map<String, String> gamesMap = JSONDeserializerUtil.deserializeMap(gamesInputStream, String.class, String.class);
        System.out.println("Select game (type in topic):");
        gamesMap.forEach((key, value) -> {
            System.out.println(key);
        });
        String selectedGame = scanner.nextLine();
        InputStream gameInputStream = Main.class.getResourceAsStream(gamesMap.get(selectedGame));
        Game game = JSONDeserializerUtil.deserialize(gameInputStream, Game.class);

        System.out.println("Select a player:");
        for (int i = 1; i <= game.getPlayers().size(); i++) {
            System.out.println(i + ". " + game.getPlayers().get(i - 1).getName());
        }

        String selectedActor = scanner.nextLine();
        Player player = game.getPlayers().get(Integer.valueOf(selectedActor) - 1);

        GameLoop gameLoop = new GameLoop();
        gameLoop.setPlayer(player);
        gameLoop.setActions(game.getActions());
        gameLoop.setBots(game.getBots());
        gameLoop.setScanner(scanner);

        Thread thread = new Thread(gameLoop);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static InputStream getResource(String filePath) {
        return Main.class.getResourceAsStream(filePath);
    }
}
