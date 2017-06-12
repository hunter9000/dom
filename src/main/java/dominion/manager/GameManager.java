package dominion.manager;

import dominion.model.Player;
import dominion.model.game.Card;
import dominion.model.game.CardStack;
import dominion.model.game.CardType;
import dominion.model.game.Game;
import dominion.repository.UserRepository;
import dominion.request.CreateGameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class GameManager {

    private static int NUM_COPPER_CARDS = 60;
    private static int NUM_SILVER_CARDS = 40;
    private static int NUM_GOLD_CARDS = 30;

    private static int STARTING_HAND_COPPER = 7;
    private static int STARTING_HAND_ESTATES = 3;

    @Autowired
    private UserRepository userRepository;

    /** Creates a new Game object based on the request. Assumes the request has been validated. */
    public Game createGame(CreateGameRequest createGameRequest) {
        Game game = new Game();
        game.setCardStacks(new ArrayList<>());
        game.setPlayers(new ArrayList<>());

        int numPlayers = createGameRequest.selectedPlayers.size();

        for (Long userId : createGameRequest.selectedPlayers) {
            Player player = new Player();
            player.setUser(userRepository.findOne(userId));
            player.setGame(game);

            // create player hand
            Set<Card> hand = new HashSet<>();
            for (int i=0; i<STARTING_HAND_COPPER; i++) {
                hand.add(new Card(CardType.COPPER));
            }
            for (int i=0; i<STARTING_HAND_ESTATES; i++) {
                hand.add(new Card(CardType.ESTATE));
            }
            player.setHand(hand);
            game.getPlayers().add(player);
        }

        game.setCurrPlayer(game.getPlayers().get(0));

        // create the treasure piles using the rest of the treasure cards from the box
        game.getCardStacks().add(new CardStack(game, CardType.COPPER, getNumberOfCopperCards(numPlayers) ));
        game.getCardStacks().add(new CardStack(game, CardType.SILVER, getNumberOfSilverCards(numPlayers)));
        game.getCardStacks().add(new CardStack(game, CardType.GOLD, getNumberOfGoldCards(numPlayers)));

        // create victory card stacks
        game.getCardStacks().add(new CardStack(game, CardType.ESTATE, getNumberOfEstateAndDuchyCards(numPlayers) ));
        game.getCardStacks().add(new CardStack(game, CardType.DUCHY, getNumberOfEstateAndDuchyCards(numPlayers) ));
        game.getCardStacks().add(new CardStack(game, CardType.PROVINCE, getNumberOfProvinceCards(numPlayers) ));

        // create curse cards
        game.getCardStacks().add(new CardStack(game, CardType.CURSE, getNumberOfCurseCards(numPlayers) ));

        // create kinddom card stacks
        for (CardType cardType : createGameRequest.selectedCards) {
            game.getCardStacks().add(new CardStack(game, cardType, 10));
        }

        return game;
    }

    private int getNumberOfCurseCards(int numPlayers) {
        return (int)Math.ceil((double)numPlayers / 2) * 10;
    }

    private int getNumberOfCopperCards(int numPlayers) {
        int base = NUM_COPPER_CARDS-(numPlayers*STARTING_HAND_COPPER);
        return (numPlayers < 5) ? base : base*2;
    }

    private int getNumberOfSilverCards(int numPlayers) {
        return (numPlayers < 5) ? NUM_SILVER_CARDS : NUM_SILVER_CARDS*2;
    }

    private int getNumberOfGoldCards(int numPlayers) {
        return (numPlayers < 5) ? NUM_GOLD_CARDS : NUM_GOLD_CARDS*2;
    }

    private int getNumberOfEstateAndDuchyCards(int numPlayers) {
        if (numPlayers <= 2) {
            return 8;
        }
        else {
            return 12;
        }
    }

    private int getNumberOfProvinceCards(int numPlayers) {
        if (numPlayers <= 2) {
            return 8;           // for 2 players
        }
        else if (numPlayers <= 4) {
        return 12;              // for 3-4 players
        }
        else if (numPlayers <= 5) {
            return 15;          // for 5 players
        }
        else {
            return 18;          // for 6 players
        }
    }
}
