package dominion.model.game;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    public Card() {

    }
    public Card(CardType cardType) {
        this.cardType = cardType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "card_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
