package baseball.domain;

import java.util.List;

public class BaseballNumbers {
    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public BaseballNumbers of(List<Integer> baseballNumbers) {
        return new BaseballNumbers(
                baseballNumbers.stream().map(BaseballNumber::from).toList()
        );
    }





}
