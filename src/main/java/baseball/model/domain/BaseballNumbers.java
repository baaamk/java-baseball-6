package baseball.model.domain;

import baseball.model.domain.vo.BaseballNumber;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers of(List<Integer> baseballNumbers) {
        return new BaseballNumbers(
                baseballNumbers.stream().map(BaseballNumber::from).toList()
        );
    }

    public Result compareNumber(BaseballNumbers userNumber) {
        int strike = (int) IntStream.range(0, baseballNumbers.size())
                .filter(i -> isStrikeAt(userNumber.baseballNumbers.get(i), i))
                .count();

        long common = userNumber.baseballNumbers.stream()
                .filter(baseballNumbers::contains)
                .count();

        int ball = (int) (common - strike);

        return new Result(strike, ball);
    }

    private boolean isStrikeAt(BaseballNumber guess, int index) {
        return baseballNumbers.get(index).equals(guess);
    }

}
