package com.github.barsch2006.kniffel.game.httpdata;

import com.github.barsch2006.kniffel.game.KniffelFields;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class BookRequest {
    private KniffelFields field;
}
