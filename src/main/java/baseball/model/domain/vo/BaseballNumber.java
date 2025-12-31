package baseball.model.domain.vo;

import java.util.Objects;

public class BaseballNumber {
    private final int baseballNumber;

    private BaseballNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber from(int baseballNumber) {
        return new BaseballNumber(baseballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return baseballNumber == that.baseballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(baseballNumber);
    }
}
