package com.github.barsch2006.kniffel.game.httpdata;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetGamesPlayersResponse {
    public String[] playerNames;

    public GetGamesPlayersResponse(String[] playerNames) {
        this.playerNames = playerNames;
    }
}
