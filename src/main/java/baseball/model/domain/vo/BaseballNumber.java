package baseball.model.domain.vo;

public class BaseballNumber {
    private final int baseballNumber;

    private BaseballNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber from(int baseballNumber) {
        return new BaseballNumber(baseballNumber);
    }
}
