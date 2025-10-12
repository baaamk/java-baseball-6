package baseball.service;

import baseball.model.BaseballGame;

public class BaseBallGameService {

    private final BaseballGame baseballGame;

    public BaseBallGameService() {
        this.baseballGame = new BaseballGame();
    }

    public void gameSetting(){
        baseballGame.createRandomNumber();
    }

    public String numberMatching(String value) {
        return baseballGame.matchNumber(value);
    }
}
