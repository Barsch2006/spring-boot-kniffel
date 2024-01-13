package com.github.barsch2006.kniffel.game.httpdata;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RollDiceRequest {
    private boolean[] dice;
}
