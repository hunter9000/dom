package dominion.controller;

import dominion.model.game.CardType;
import dominion.model.game.ExpansionType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class CardController {

//    @Autowired
//    private CardRepository cardRepository;

    @RequestMapping(value="/api/expansions/", method = RequestMethod.GET)
    public Map<ExpansionType, ExpansionType> getExpansions() {
        return Arrays.stream(ExpansionType.values()).collect(Collectors.toMap(Function.identity(), Function.identity()));
    }

    /** Gets the kingdom cards that are included in one of the expansion sets requested */
    @RequestMapping(value="/api/cards/", method= RequestMethod.GET)
    public Map<CardType, CardType> getAllCardTypes(@RequestParam("expansions") List<ExpansionType> expansionTypes) {
        return Arrays.stream(CardType.values()).filter((CardType type) -> expansionTypes.contains(type.getExpansionType())).collect(Collectors.toMap(Function.identity(), Function.identity()));
    }

}
