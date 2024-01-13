package com.github.barsch2006.kniffel.game;

import lombok.Getter;

import java.util.HashMap;

public class Player {
    public String name;
    private HashMap<KniffelFields, Integer> fieldsWithScore = new HashMap<>();
    private HashMap<KniffelFields, Boolean> fieldsUsed = new HashMap<>();

    @Getter
    private HashMap<Integer, Dice> dice;

    public Player(String name) {
        this.name = name;
        for (KniffelFields field : KniffelFields.values()) {
            this.fieldsWithScore.put(field, 0);
            this.fieldsUsed.put(field, false);
        }

        this.dice = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            this.dice.put(i, new Dice());
        }
    }

    public int getScore() {
        // calculate score
        int score = 0;
        for (KniffelFields field : KniffelFields.values()) {
            if (this.fieldsUsed.get(field)) {
                score += this.fieldsWithScore.get(field);
            }
        }
        return score;
    }

    public void resetDice() {
        for (int i = 0; i < 5; i++) {
            this.dice.get(i).setLocked(false);
        }
    }

    public void rollDice() {
        for (int i = 0; i < 5; i++) {
            this.dice.get(i).roll();
        }
    }

    public void setField(KniffelFields field, int score) {
        if (this.fieldsUsed.get(field)) {
            throw new IllegalArgumentException("Field already used");
        }
        this.fieldsWithScore.put(field, score);
        this.fieldsUsed.put(field, true);
    }

    public int getField(KniffelFields field) {
        return this.fieldsWithScore.get(field);
    }

    public boolean isFieldUsed(KniffelFields field) {
        return this.fieldsUsed.get(field);
    }

    public int[] fieldsWithScoreToArray() {
        int[] fields = new int[KniffelFields.values().length];
        for (int i = 0; i < KniffelFields.values().length; i++) {
            fields[i] = this.fieldsWithScore.get(KniffelFields.values()[i]);
        }
        return fields;
    }

    public boolean[] fieldsUsedToArray() {
        boolean[] fields = new boolean[KniffelFields.values().length];
        for (int i = 0; i < KniffelFields.values().length; i++) {
            fields[i] = this.fieldsUsed.get(KniffelFields.values()[i]);
        }
        return fields;
    }
}
