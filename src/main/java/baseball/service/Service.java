package baseball.service;

import baseball.model.domain.BaseballNumbers;
import baseball.model.domain.Result;

import java.util.List;

public class Service {
    public Result showResult(BaseballNumbers baseballNumbers, List<Integer> parsedInputNumbers) {
        BaseballNumbers userNumbers = BaseballNumbers.of(parsedInputNumbers);
        return baseballNumbers.compareNumber(userNumbers);
    }
}

