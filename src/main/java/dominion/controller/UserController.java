package dominion.controller;

import dominion.model.user.User;
import dominion.repository.UserRepository;
import dominion.response.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/api/players/", method = RequestMethod.GET)
    public List<PlayerResponse> getPlayers() {
        List<PlayerResponse> ret = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            ret.add(new PlayerResponse(user));
        }
        return ret;
    }

}
