package baseball.model.domain;

public class Result {
    private final int strike;
    private final int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isStrike(int expected) {
        return strike == expected;
    }

    public boolean isBall(int expected) {
        return ball == expected;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
