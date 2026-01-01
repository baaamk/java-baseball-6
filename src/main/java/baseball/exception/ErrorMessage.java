package baseball.exception;

public enum ErrorMessage {
    INVALID_DUPLICATE_AND_RANGE_NUMBER("1~9 사이의 중복 없는 3자리 숫자를 입력하세요."),
    INVALID_RETRY_NUMBER("1 또는 2의 숫자만 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
