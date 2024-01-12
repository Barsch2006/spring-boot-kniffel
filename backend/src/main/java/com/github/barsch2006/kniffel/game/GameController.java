package com.github.barsch2006.kniffel.game;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {
    @PostMapping("/")
    public void createGame(
            @RequestBody CreateGameRequest createGameRequest) {
        System.out.println("createGameRequest = " + createGameRequest);
    }

    @GetMapping("/{gameId}")
    public void getGameInfo(
            // the annotation @PathVariable tells spring to take the parameter data from the URL
            @PathVariable String gameId) {
        System.out.println("gameId = " + gameId);
    }
}
