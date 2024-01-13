package com.github.barsch2006.kniffel.game.httpdata;

import com.github.barsch2006.kniffel.game.Dice;

public class RollDiceResponse {
    public int[] diceToRoll;
    public int[] diceToKeep;

    public RollDiceResponse(Dice[] dice) {
        int diceToRollCount = 0;
        int diceToKeepCount = 0;
        for (Dice di : dice) {
            if (!di.locked) {
                diceToRollCount++;
            } else {
                diceToKeepCount++;
            }
        }
        diceToRoll = new int[diceToRollCount];
        diceToKeep = new int[diceToKeepCount];
        int diceToRollIndex = 0;
        int diceToKeepIndex = 0;
        for (Dice di : dice) {
            if (!di.locked) {
                diceToRoll[diceToRollIndex] = di.getValue();
                diceToRollIndex++;
            } else {
                diceToKeep[diceToKeepIndex] = di.getValue();
                diceToKeepIndex++;
            }
        }
    }
}
