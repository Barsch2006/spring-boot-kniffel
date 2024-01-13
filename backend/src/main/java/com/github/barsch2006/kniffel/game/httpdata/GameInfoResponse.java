package com.github.barsch2006.kniffel.game.httpdata;

import com.github.barsch2006.kniffel.game.Dice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GameInfoResponse {
    public String[] playerNames;
    public int currentScore;
    public int[] fields;
    public boolean[] fieldsSet;
    public Dice[] dice;

    public GameInfoResponse(String[] playerNames, int currentScore, int[] fields, boolean[] fieldsSet, Dice[] dice) {
        this.playerNames = playerNames;
        this.currentScore = currentScore;
        this.fields = fields;
        this.fieldsSet = fieldsSet;
        this.dice = dice;
    }
}
