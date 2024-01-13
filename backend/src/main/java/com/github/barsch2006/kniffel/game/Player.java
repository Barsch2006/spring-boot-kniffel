package com.github.barsch2006.kniffel.game;

public class Player {
    public String name;
    private int score;
    private boolean isPlaying;
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.isPlaying = false;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public boolean getIsPlaying() {
        return this.isPlaying;
    }
}
