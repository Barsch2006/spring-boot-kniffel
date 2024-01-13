package com.github.barsch2006.kniffel.game;

import java.util.HashMap;

public class Game {
    public HashMap<String, Player> players = new HashMap<>();
    public String id;

    public Game(String[] names) {
        this.id = Game.createGameID();
        for (String name : names) {
            players.put(name, new Player(name));
        }
    }

    private static String createGameID() {
        // 6 character long game ID
        String gameId = "";
        for (int i = 0; i < 6; i++) {
            gameId += (char) (Math.random() * 26 + 65);
        }
        return gameId;
    }

    public Player[] getWinners() {
        // sort the players by their score
        Player[] sortedPlayers = players.values().toArray(new Player[0]);
        for (int i = 0; i < sortedPlayers.length; i++) {
            for (int j = i + 1; j < sortedPlayers.length; j++) {
                if (sortedPlayers[i].getScore() < sortedPlayers[j].getScore()) {
                    Player temp = sortedPlayers[i];
                    sortedPlayers[i] = sortedPlayers[j];
                    sortedPlayers[j] = temp;
                }
            }
        }
        return sortedPlayers;
    }
}
