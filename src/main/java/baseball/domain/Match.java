package baseball.domain;

import baseball.exception.NoMatchingNumberException;

public enum Match {
    BALL("볼"),
    STRIKE("스트라이크");

    private final String message;

    Match(String message) {
        this.message = message;
    }

    public static Match of(boolean hasMatchingNumber, boolean hasCorrectMatchIndex) {
        if (hasMatchingNumber && hasCorrectMatchIndex) {
            return STRIKE;
        }

        if (hasMatchingNumber) {
            return BALL;
        }

        throw new NoMatchingNumberException();
    }

    public String getMessage() {
        return message;
    }
}
