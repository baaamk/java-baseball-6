package baseball.exception;

/**
 * 오류 메시지를 정의한 enum 클래스
 */
public enum ErrorMessage {
    // BaseballNumber Error
    INVALID_NUMBER_SIZE("숫자는 세자리여야 합니다."),
    NUMBER_OUT_OF_RANGE("각 자리의 숫자는 1~9 사이의 정수여야 합니다."),
    NUMBER_NULL_OR_BLANK("숫자는 비워두거나 공백을 포함할 수 없습니다."),
    NUMBER_NOT_NUMERIC("숫자가 아닌 문자를 포함할 수 없습니다."),
    NUMBER_DUPLICATED("세자리의 숫자는 서로 중복될 수 없습니다."),

    // BaseballService Error
    INVALID_ANSWER("1 또는 2로 답변해야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
