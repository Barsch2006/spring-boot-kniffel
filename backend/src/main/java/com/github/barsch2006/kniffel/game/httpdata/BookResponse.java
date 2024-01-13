package com.github.barsch2006.kniffel.game.httpdata;

import lombok.*;

@Getter
@Setter
@ToString
public class BookResponse {
    public int score;
    public int[] fields;
    public boolean[] fieldsSet;

    public BookResponse(int score, int[] fields, boolean[] fieldsSet) {
        this.score = score;
        this.fields = fields;
        this.fieldsSet = fieldsSet;
    }
}
