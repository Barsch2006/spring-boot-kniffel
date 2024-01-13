package com.github.barsch2006.kniffel.game;

import com.github.barsch2006.kniffel.game.httpdata.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {
    @Autowired
    private GameService gameservice;

    @PostMapping("/")
    public String createGame(
            @RequestBody CreateGameRequest createGameRequest) {
        return gameservice.createGame(createGameRequest.getPlayerNames()).id;
    }

    @GetMapping("/{gameId}")
    public GetGamesPlayersResponse getGamesPlayerNames(@PathVariable String gameId) {
        Game game = gameservice.byId(gameId);
        if (game == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid game ID");
        }
        String[] playerNames = game.players.keySet().toArray(new String[0]);
        return new GetGamesPlayersResponse(playerNames);
    }

    @GetMapping("/{gameId}/{playerName}")
    public GameInfoResponse getGameInfo(@PathVariable String gameId, @PathVariable String playerName) {
        Game game = gameservice.byId(gameId);
        if (game == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid game ID");
        }
        if (!game.players.containsKey(playerName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Player does not exist");
        }
        Player player = game.players.get(playerName);
        return gameservice.getGameInfo(game, player);
    }

    @PostMapping("/{gameId}/{playerName}/roll")
    public RollDiceResponse roll(@PathVariable String gameId, @PathVariable String playerName) {
        return gameservice.rollDice(gameservice.byId(gameId).players.get(playerName));
    }

    @PostMapping("/{gameId}/{playerName}/keep")
    public RollDiceResponse keep(@PathVariable String gameId, @PathVariable String playerName, @RequestBody RollDiceRequest reqBody) {
        return gameservice.keepDice(gameservice.byId(gameId).players.get(playerName), reqBody.getDice());
    }
}
