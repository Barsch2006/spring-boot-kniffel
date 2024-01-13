package com.github.barsch2006.kniffel.game.httpdata;

import lombok.*;

@Getter
@Setter
// this creates a method "toString()" which returns all attributes of the class
// we need this to make System.out.println work on this class
@ToString
public class CreateGameRequest {
    private String[] playerNames;
}
