package dominion.request;

import dominion.model.game.CardType;
import dominion.model.game.ExpansionType;

import java.util.List;

public class CreateGameRequest {
    public List<Long> selectedPlayers;
    public List<ExpansionType> selectedExpansions;
    public List<CardType> selectedCards;

    public boolean validate() {
        // verify 2 - 6 players
        if (selectedPlayers.size() < 2 || selectedPlayers.size() > 6) {
            return false;
        }
        // verify 10 kingdom cards
        if (selectedCards.size() != 10) {
            return false;
        }
        return true;
    }
}
