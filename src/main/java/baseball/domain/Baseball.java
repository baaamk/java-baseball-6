package baseball.domain;

import baseball.service.BaseballNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Baseball {
    private List<Integer> computerBaseballNumbers;

    public Baseball() {
        this.computerBaseballNumbers = new ArrayList<>();
    }

    public void computerNumbersGenerator() {
        computerBaseballNumbers = BaseballNumberGenerator.generator();
    }

    public String compare(List<Integer> convertedNumbers) {
        StringBuilder sb = new StringBuilder();
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < 3; i ++) {
            if(Objects.equals(computerBaseballNumbers.get(i), convertedNumbers.get(i))) {
                strike += 1;
            }
            else if (computerBaseballNumbers.contains(convertedNumbers.get(i))) {
                ball += 1;
            }
        }
        if(strike != 0 && ball != 0) {
            sb.append(ball).append("볼 ").append(strike).append("스트라이크");
        }
        else if(strike == 0 && ball != 0) {
            sb.append(ball).append("볼");
        }
        else if(ball == 0 && strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        else if(strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        return sb.toString();
    }

}
