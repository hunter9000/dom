package dominion.model.game;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CardType {
    COPPER(CardSubType.TREASURE, null, 0, 1, 0, 0, 0),
    SILVER(CardSubType.TREASURE, null, 3, 2, 0, 0, 0),
    GOLD(CardSubType.TREASURE, null, 6, 3, 0, 0, 0),

    ESTATE(CardSubType.VICTORY, null, 2, 0, 0, 0, 0),
    DUCHY(CardSubType.VICTORY, null, 5, 0, 0, 0, 0),
    PROVINCE(CardSubType.VICTORY, null, 8, 0, 0, 0, 0),

    CURSE(CardSubType.CURSE, ExpansionType.BASE, 0, 0, 0, 0, 0),
                            // money, card, buy, action
    CELLAR(CardSubType.ACTION, ExpansionType.BASE, 2, 0, 0, 0, 1),
    CHAPEL(CardSubType.ACTION, ExpansionType.BASE, 2, 0, 0, 0, 0),
    MOAT(CardSubType.REACTION, ExpansionType.BASE, 2, 0, 2, 0, 0),
//    CHANCELLOR(CardSubType.ACTION, 3, 2, 0, 0, 0),
    HARBINGER(CardSubType.ACTION, ExpansionType.BASE, 3, 0, 1, 0, 1),
    MERCHANT(CardSubType.ACTION, ExpansionType.BASE, 3, 0, 1, 0, 1),
    VASSAL(CardSubType.ACTION, ExpansionType.BASE, 3, 2, 0, 0, 0),
    VILLAGE(CardSubType.ACTION, ExpansionType.BASE, 3, 0, 1, 0, 2),
//    WOODCUTTER(CardSubType.ACTION, 3, 2, 0, 1, 0),
    WORKSHOP(CardSubType.ACTION, ExpansionType.BASE, 3, 0, 0, 0, 0),
    BUREAUCRAT(CardSubType.ATTACK, ExpansionType.BASE, 4, 0, 0, 0, 0),
//    FEAST(CardSubType.ACTION, 4, 0, 0, 0, 0),
    GARDENS(CardSubType.VICTORY, ExpansionType.BASE, 4, 0, 0, 0, 0),
    MILITIA(CardSubType.ATTACK, ExpansionType.BASE, 4, 2, 0, 0, 0),
    MONEYLENDER(CardSubType.ACTION, ExpansionType.BASE, 4, 0, 0, 0, 0),
    POACHER(CardSubType.ACTION, ExpansionType.BASE, 4, 1, 1, 0, 1),
    REMODEL(CardSubType.ACTION, ExpansionType.BASE, 4, 0, 0, 0, 0),
    SMITHY(CardSubType.ACTION, ExpansionType.BASE, 4, 0, 3, 0, 0),
//    SPY(CardSubType.ATTACK, 4, 0, 1, 0, 1),
//    THIEF(CardSubType.ATTACK, 4, 0, 0, 0, 0),
    THRONE_ROOM(CardSubType.ACTION, ExpansionType.BASE, 4, 0, 0, 0, 0),
    BANDIT(CardSubType.ATTACK, ExpansionType.BASE, 5, 0, 0, 0, 0),
    COUNCIL_ROOM(CardSubType.ACTION, ExpansionType.BASE, 5, 0, 4, 1, 0),
    FESTIVAL(CardSubType.ACTION, ExpansionType.BASE, 5, 2, 0, 1, 2),
    LABORATORY(CardSubType.ACTION, ExpansionType.BASE, 5, 0, 2, 0, 1),
    LIBRARY(CardSubType.ACTION, ExpansionType.BASE, 5, 0, 0, 0, 0),
    MARKET(CardSubType.ACTION, ExpansionType.BASE, 5, 1, 1, 1, 1),
    MINE(CardSubType.ACTION, ExpansionType.BASE, 5, 0, 0, 0, 0),
    SENTRY(CardSubType.ACTION, ExpansionType.BASE, 5, 0, 1, 0, 1),
    WITCH(CardSubType.ATTACK, ExpansionType.BASE, 5, 0, 2, 0, 0),
    ARTISAN(CardSubType.ACTION, ExpansionType.BASE, 6, 0, 0, 0, 0)
//    ADVENTURER(CardSubType.ACTION, 6, 0, 0, 0, 0)
    ;

    private CardSubType cardSubType;
    private ExpansionType expansionType;
    private Integer moneyCost;

    private Integer moneyBonus;
    private Integer cardBonus;
    private Integer buyBonus;
    private Integer actionBonus;

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

    private CardType(CardSubType cardSubType, ExpansionType expansionType, Integer moneyCost, Integer moneyBonus, Integer cardBonus, Integer buyBonus, Integer actionBonus) {
        this.cardSubType = cardSubType;
        this.expansionType = expansionType;
        this.moneyCost = moneyCost;
        this.moneyBonus = moneyBonus;
        this.cardBonus = cardBonus;
        this.buyBonus = buyBonus;
        this.actionBonus = actionBonus;
    }
}
