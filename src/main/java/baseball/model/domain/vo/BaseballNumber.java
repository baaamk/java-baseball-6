package baseball.model.domain.vo;

import baseball.exception.ErrorMessage;

import java.util.Objects;

public class BaseballNumber {
    private final int baseballNumber;

    private BaseballNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber from(int baseballNumber) {
        validateNumber(baseballNumber);
        return new BaseballNumber(baseballNumber);
    }

    private static void validateNumber(int baseballNumber) {
        if (baseballNumber < 1 || baseballNumber > 9) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_AND_RANGE_NUMBER.getMessage());
        }
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
