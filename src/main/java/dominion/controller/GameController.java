package dominion.controller;

import dominion.manager.GameManager;
import dominion.model.Player;
import dominion.model.game.Game;
import dominion.repository.GameRepository;
import dominion.request.CreateGameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameManager gameManager;

    @RequestMapping(value="/api/game/", method = RequestMethod.GET)
    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    @RequestMapping(value="/api/game/{gameId}/", method = RequestMethod.GET)
    public Game getGame(@PathVariable Long gameId) {
        return gameRepository.findOne(gameId);
    }

    @RequestMapping(value="/api/game/{gameId}/currentplayer", method = RequestMethod.GET)
    public Player getCurrentPlayer(@PathVariable Long gameId) {
        return gameRepository.findOne(gameId).getCurrPlayer();
    }

    @RequestMapping(value="/api/game/", method = RequestMethod.POST)
    public Game createGame(@RequestBody CreateGameRequest createGameRequest) {
        if (!createGameRequest.validate()) {
//            throw new BadRequestException();
        }

        Game game = gameManager.createGame(createGameRequest);

        gameRepository.save(game);
        return game;
    }


}
