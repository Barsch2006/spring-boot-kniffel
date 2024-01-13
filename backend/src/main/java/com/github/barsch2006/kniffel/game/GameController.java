package com.github.barsch2006.kniffel.game;

import com.github.barsch2006.kniffel.game.httpdata.CreateGameRequest;
import com.github.barsch2006.kniffel.game.httpdata.GetGamesPlayersResponse;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {

    HashMap<String, Game> games = new HashMap<>();

    @PostMapping("/")
    public String createGame(
            @RequestBody CreateGameRequest createGameRequest) {
        // create game ID
        String gameId = _createGameID();
        // create game
        Game game = new Game(createGameRequest.getPlayerNames());
        // add game to games
        games.put(gameId, game);
        // send the game ID back to the client
        return gameId;
    }

    private String _createGameID() {
        // 6 character long game ID
        String gameId = "";
        for (int i = 0; i < 6; i++) {
            gameId += (char) (Math.random() * 26 + 65);
        }
        // check if game ID already exists
        if (games.containsKey(gameId)) {
            // if it does, try again
            return _createGameID();
        }
        return gameId;
    }

    @GetMapping("/{gameId}")
    public GetGamesPlayersResponse getGamesPlayerNames(@PathVariable String gameId) {
        Game game = games.get(gameId);
        if (game == null) {
            // todo throw error (game not found)
        }
        String[] playerNames = game.players.keySet().toArray(new String[0]);
        return new GetGamesPlayersResponse(playerNames);
    }

    @GetMapping("/{gameId}/{playerName}")
    public void getGameInfo(@PathVariable String gameId, @PathVariable String playerName) {
        Game game = games.get(gameId);
        if (game == null) {
            // todo throw error (game not found)
        }
        if (!game.players.containsKey(playerName)) {
            // todo throw error (player does not exists)
        }
        if (game.players.get(playerName).getIsPlaying()) {
            // todo throw error (player is already playing)
            // no double sessions for one player allowed
        }
        game.players.get(playerName).setIsPlaying(true);
        // todo: return game info
    }
}
