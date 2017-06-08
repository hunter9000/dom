package dominion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dominion.model.game.Card;
import dominion.model.game.Game;
import dominion.model.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/** Thin wrapper around a user that can be returned to other users when selecting players. */
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game", nullable = false)
    private Game game;

    @ManyToMany()
    @JoinTable(name = "player_deck",
            joinColumns = {@JoinColumn(name = "playerId", nullable = false, updatable = false) },		// column that points to this table
            inverseJoinColumns = { @JoinColumn(name = "cardId", nullable = false, updatable = false) })		// column that points to the benefittable table
    private List<Card> deck;

    @ManyToMany()
    @JoinTable(name = "player_hand",
            joinColumns = {@JoinColumn(name = "playerId", nullable = false, updatable = false) },		// column that points to this table
            inverseJoinColumns = { @JoinColumn(name = "cardId", nullable = false, updatable = false) })		// column that points to the benefittable table
    private Set<Card> hand;

    @ManyToMany()
    @JoinTable(name = "player_discard",
            joinColumns = {@JoinColumn(name = "playerId", nullable = false, updatable = false) },		// column that points to this table
            inverseJoinColumns = { @JoinColumn(name = "cardId", nullable = false, updatable = false) })		// column that points to the benefittable table
    private Set<Card> discard;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public List<Card> getDeck() {
        return deck;
    }
    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public Set<Card> getHand() {
        return hand;
    }
    public void setHand(Set<Card> hand) {
        this.hand = hand;
    }

    public Set<Card> getDiscard() {
        return discard;
    }
    public void setDiscard(Set<Card> discard) {
        this.discard = discard;
    }
}
