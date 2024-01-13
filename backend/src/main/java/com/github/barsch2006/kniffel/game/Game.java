package com.github.barsch2006.kniffel.game;

import java.util.HashMap;

public class Game {
    public HashMap<String, Player> players = new HashMap<>();

    public Game(String[] names) {
        for (String name : names) {
            players.put(name, new Player(name));
        }
    }
}
