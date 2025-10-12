package baseball.domain;

public class GameResult {
    int ball;
    int strike;
    boolean isFinish;

    public GameResult() {
    }

    public void reset() {
        ball = 0;
        strike = 0;
        isFinish = false;
    }

    public void plusBall() {
        ball++;
    }

    public void plusStrike() {
        strike++;
    }

    public void changeIsFinishTrue() {
        isFinish = true;
    }
}
