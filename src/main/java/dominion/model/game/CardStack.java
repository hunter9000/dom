package dominion.model.game;

import javax.persistence.*;

@Entity
@Table(name = "card_stack")
public class CardStack {

    public CardStack() {

    }
    public CardStack(Game game, CardType cardType, Integer quantity) {
        this.game = game;
        this.cardType = cardType;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game", nullable = false)
    private Game game;

    @Column(name = "card_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name = "quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public CardType getCardType() {
        return cardType;
    }
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


