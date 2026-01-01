package baseball.controller.dto;

import baseball.model.domain.Result;

public record ResultMapper(int strike, int ball) {
    public static ResultMapper from(Result result) {
        return new ResultMapper(result.getStrike(), result.getBall());
    }
}