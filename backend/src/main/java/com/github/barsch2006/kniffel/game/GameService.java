package com.github.barsch2006.kniffel.game;

import com.github.barsch2006.kniffel.game.httpdata.GameInfoResponse;
import com.github.barsch2006.kniffel.game.httpdata.GetGamesPlayersResponse;
import com.github.barsch2006.kniffel.game.httpdata.RollDiceResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GameService {
    private HashMap<String, Game> games = new HashMap<>();

    public Game createGame(String[] playernames) {
        // create game
        Game game = new Game(playernames);
        // add game to games
        games.put(game.id, game);
        // return game ID
        return game;
    }

    public Game byId(String id) {
        return games.get(id);
    }

    public GameInfoResponse getGameInfo(Game game, Player player) {
        return new GameInfoResponse(
                game.players.keySet().toArray(new String[0]),
                player.getScore(),
                player.fieldsWithScoreToArray(),
                player.fieldsUsedToArray(),
                player.getDice().keySet().toArray(new Dice[0])
        );
    }

    public RollDiceResponse rollDice(Player player) {
        player.getDice().forEach((key, value) -> {
            if (!value.locked) {
                value.roll();
            }
        });
        return new RollDiceResponse(player.getDice().keySet().toArray(new Dice[0]));
    }

    public RollDiceResponse keepDice(Player player, boolean[] dice) {
        for (int i = 0; i < dice.length; i++) {
            player.getDice().get(i).setLocked(dice[i]);
        }
        return new RollDiceResponse(player.getDice().keySet().toArray(new Dice[0]));
    }

    public GetGamesPlayersResponse calcWinner(String gameid) {
        Game game = games.get(gameid);
        Player[] players = game.getWinners();
        String[] winners = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            winners[i] = players[i].name;
        }
        return new GetGamesPlayersResponse(winners);
    }
}
