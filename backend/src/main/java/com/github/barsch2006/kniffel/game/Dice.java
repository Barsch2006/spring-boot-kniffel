package com.github.barsch2006.kniffel.game;

import lombok.Getter;

public class Dice {

    @Getter
    private int value;

    public boolean locked = false;
    public Dice() {
    }

    public void roll() {
        if (!locked) {
            this.value = (int) (Math.random() * 6) + 1;
        }
    }

    public void setLocked(Boolean val) {
        this.locked = val;
    }
}
