package dominion.controller;

import dominion.model.Player;
import dominion.model.game.Game;
import dominion.repository.GameRepository;
import dominion.repository.UserRepository;
import dominion.request.CreateGameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/api/game/", method = RequestMethod.GET)
    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    @RequestMapping(value="/api/game/", method = RequestMethod.POST)
    public Game createGame(@RequestBody CreateGameRequest createGameRequest) {
        Game game = new Game();

        for (Long userId : createGameRequest.selectedPlayers) {
            Player player = new Player();
            player.setUser(userRepository.findOne(userId));
            player.setGame(game);
        }

        gameRepository.save(game);
        return game;
    }


}
