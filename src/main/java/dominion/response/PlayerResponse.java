package dominion.response;

import dominion.model.user.User;

public class PlayerResponse {

    public String userName;
    public Long userId;

    public PlayerResponse(User user) {
        this.userName = user.getUsername();
        this.userId = user.getId();
    }

}
