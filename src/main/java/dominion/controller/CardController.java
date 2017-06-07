package dominion.controller;

import dominion.model.game.CardType;
import dominion.model.game.ExpansionType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CardController {

//    @Autowired
//    private CardRepository cardRepository;

    @RequestMapping(value="/api/expansions/", method = RequestMethod.GET)
    public List<ExpansionType> getExpansions() {
        return Arrays.asList(ExpansionType.values());
    }

    /** Gets the kingdom cards that are included in one of the expansion sets requested */
    @RequestMapping(value="/api/cards/", method= RequestMethod.GET)
    public List<CardType> getAllCardTypes(@RequestParam("expansions") List<ExpansionType> expansionTypes) {
        return Arrays.stream(CardType.values()).filter((CardType type) -> expansionTypes.contains(type.getExpansionType())).collect(Collectors.toList());
    }

}
