package dominion.repository;

import dominion.model.game.Game;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value="gameRepository")
public interface GameRepository extends CrudRepository<Game, Long> {
}
