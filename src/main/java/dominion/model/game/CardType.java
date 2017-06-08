package dominion.model.game;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CardType {
    COPPER("Copper", CardSubType.TREASURE, null, 0, 1, 0, 0, 0),
    SILVER("Silver", CardSubType.TREASURE, null, 3, 2, 0, 0, 0),
    GOLD("Gold", CardSubType.TREASURE, null, 6, 3, 0, 0, 0),

    ESTATE("Estate", CardSubType.VICTORY, null, 2, 0, 0, 0, 0),
    DUCHY("Duchy", CardSubType.VICTORY, null, 5, 0, 0, 0, 0),
    PROVINCE("Province", CardSubType.VICTORY, null, 8, 0, 0, 0, 0),

    CURSE("Curse", CardSubType.CURSE, ExpansionType.BASE, 0, 0, 0, 0, 0),
                            // money, card, buy, action
    CELLAR("Cellar", CardSubType.ACTION, ExpansionType.BASE, 2, 0, 0, 0, 1),
    CHAPEL("Chapel", CardSubType.ACTION, ExpansionType.BASE, 2, 0, 0, 0, 0),
    MOAT("Moat", CardSubType.REACTION, ExpansionType.BASE, 2, 0, 2, 0, 0),
//    CHANCELLOR("", CardSubType.ACTION, 3, 2, 0, 0, 0),
    HARBINGER("Harbinger", CardSubType.ACTION, ExpansionType.BASE, 3, 0, 1, 0, 1),
    MERCHANT("Merchant", CardSubType.ACTION, ExpansionType.BASE, 3, 0, 1, 0, 1),
    VASSAL("Vassal", CardSubType.ACTION, ExpansionType.BASE, 3, 2, 0, 0, 0),
    VILLAGE("Village", CardSubType.ACTION, ExpansionType.BASE, 3, 0, 1, 0, 2),
//    WOODCUTTER("", CardSubType.ACTION, 3, 2, 0, 1, 0),
    WORKSHOP("Workshop", CardSubType.ACTION, ExpansionType.BASE, 3, 0, 0, 0, 0),
    BUREAUCRAT("Bureaucrat", CardSubType.ATTACK, ExpansionType.BASE, 4, 0, 0, 0, 0),
//    FEAST("", CardSubType.ACTION, 4, 0, 0, 0, 0),
    GARDENS("Gardens", CardSubType.VICTORY, ExpansionType.BASE, 4, 0, 0, 0, 0),
    MILITIA("Militia", CardSubType.ATTACK, ExpansionType.BASE, 4, 2, 0, 0, 0),
    MONEYLENDER("Moneylender", CardSubType.ACTION, ExpansionType.BASE, 4, 0, 0, 0, 0),
    POACHER("Poacher", CardSubType.ACTION, ExpansionType.BASE, 4, 1, 1, 0, 1),
    REMODEL("Remodel", CardSubType.ACTION, ExpansionType.BASE, 4, 0, 0, 0, 0),
    SMITHY("Smithy", CardSubType.ACTION, ExpansionType.BASE, 4, 0, 3, 0, 0),
//    SPY("", CardSubType.ATTACK, 4, 0, 1, 0, 1),
//    THIEF("", CardSubType.ATTACK, 4, 0, 0, 0, 0),
    THRONE_ROOM("Throne Room", CardSubType.ACTION, ExpansionType.BASE, 4, 0, 0, 0, 0),
    BANDIT("Bandit", CardSubType.ATTACK, ExpansionType.BASE, 5, 0, 0, 0, 0),
    COUNCIL_ROOM("Council Room", CardSubType.ACTION, ExpansionType.BASE, 5, 0, 4, 1, 0),
    FESTIVAL("Festival", CardSubType.ACTION, ExpansionType.BASE, 5, 2, 0, 1, 2),
    LABORATORY("Laboratory", CardSubType.ACTION, ExpansionType.BASE, 5, 0, 2, 0, 1),
    LIBRARY("Library", CardSubType.ACTION, ExpansionType.BASE, 5, 0, 0, 0, 0),
    MARKET("Market", CardSubType.ACTION, ExpansionType.BASE, 5, 1, 1, 1, 1),
    MINE("Mine", CardSubType.ACTION, ExpansionType.BASE, 5, 0, 0, 0, 0),
    SENTRY("Sentry", CardSubType.ACTION, ExpansionType.BASE, 5, 0, 1, 0, 1),
    WITCH("Witch", CardSubType.ATTACK, ExpansionType.BASE, 5, 0, 2, 0, 0),
    ARTISAN("Artisan", CardSubType.ACTION, ExpansionType.BASE, 6, 0, 0, 0, 0)
//    ADVENTURER(CardSubType.ACTION, 6, 0, 0, 0, 0)
    ;

    private String displayName;
    private CardSubType cardSubType;
    private ExpansionType expansionType;
    private Integer moneyCost;

    private Integer moneyBonus;
    private Integer cardBonus;
    private Integer buyBonus;
    private Integer actionBonus;

    public String getDisplayName() {
        return displayName;
    }
    public CardSubType getCardSubType() {
        return cardSubType;
    }
    public ExpansionType getExpansionType() {
        return expansionType;
    }
    public Integer getMoneyCost() {
        return moneyCost;
    }
    public Integer getMoneyBonus() {
        return moneyBonus;
    }
    public Integer getCardBonus() {
        return cardBonus;
    }
    public Integer getBuyBonus() {
        return buyBonus;
    }
    public Integer getActionBonus() {
        return actionBonus;
    }

    private CardType(String displayName, CardSubType cardSubType, ExpansionType expansionType, Integer moneyCost, Integer moneyBonus, Integer cardBonus, Integer buyBonus, Integer actionBonus) {
        this.displayName = displayName;
        this.cardSubType = cardSubType;
        this.expansionType = expansionType;
        this.moneyCost = moneyCost;
        this.moneyBonus = moneyBonus;
        this.cardBonus = cardBonus;
        this.buyBonus = buyBonus;
        this.actionBonus = actionBonus;
    }
}
