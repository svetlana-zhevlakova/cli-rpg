package com.sz.rpg.gameplay;

import com.sz.rpg.domain.actors.Bot;
import com.sz.rpg.domain.actors.Player;
import com.sz.rpg.domain.features.Feature;
import com.sz.rpg.domain.gameplay.Action;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class GameLoop implements Runnable {

    private Player player;
    private List<Action> actions;
    private List<Bot> bots;
    private Scanner scanner;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Bot> getBots() {
        return bots;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (true) {
            actions.forEach(action -> {
                Optional<Bot> bot = getBot(action.getBotId());
                bot.ifPresent(this::communicate);

            });
            if (player.getExperience() > 0) {
                System.out.println("You have won");
            } else {
                System.out.println("At leas you're alive");
            }
            break;
        }
    }

    private void communicate(Bot bot) {
        System.out.println("You have met a " + bot);
        System.out.println("Your skills: ");
        player.getAvailableFeatures().forEach(System.out::println);
        System.out.println("What would you use? (Type in the name of your skill)");
        String whatToUse = scanner.nextLine();
        Optional<Feature> featureToUse = getFeature(player.getAvailableFeatures(), (feature) -> feature.getName().equals(whatToUse));
        featureToUse.ifPresent(f -> {
            double experience = useFeature(f, bot);
            if (experience <= 0) {
                System.out.println("You loose experience.");
            } else {
                System.out.println("You gain experience.");
            }
            player.updateExperience(experience);
            System.out.println("Your current experience is: " + player.getExperience());
        });
    }

    private Optional<Bot> getBot(Long id) {
        return bots.stream()
                .filter(bot -> bot.getId().equals(id))
                .findFirst();
    }

    private Optional<Feature> getFeature(List<Feature> featureList, Predicate<Feature> predicate) {
        return featureList.stream().filter(predicate).findFirst();
    }

    private double useFeature(Feature feature, Bot bot) {
        Optional<Feature> featureOfBot = getFeature(bot.getAvailableFeatures(), (f) -> f.getFeatureType() == feature.getFeatureType());
        if (featureOfBot.isPresent()) {
            return calculateExperienceDelta(feature.getLevel(), featureOfBot.get().getLevel());
        } else {
            return 0.0;
        }
    }

    private double calculateExperienceDelta(int playerFeatureLevel, int botFeatureLevel) {
        int delta = playerFeatureLevel - botFeatureLevel;
        double experienceDelta;
        if (delta > 0) {
            experienceDelta = calculate(playerFeatureLevel, botFeatureLevel);
        } else {
            experienceDelta = -calculate(botFeatureLevel, playerFeatureLevel);
        }
        return experienceDelta;
    }

    private double calculate(int level, int anotherLevel) {
        int coef = anotherLevel <= 0 ? 1 : anotherLevel;
        return level / 100.0 * coef;
    }


}
