package dominion.request;

import dominion.model.game.CardType;
import dominion.model.game.ExpansionType;

import java.util.List;

public class CreateGameRequest {
    public List<Long> selectedPlayers;
    public List<ExpansionType> selectedExpansions;
    public List<CardType> selectedCards;
}
