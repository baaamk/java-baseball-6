package baseball.view;

/**
 * 프로그램의 모든 입력을 담당하는 인터페이스
 */
public interface InputView {
    default String readGuessingNumber() {
        return null;
    };

    default String readGameProceed() {
        return null;
    };
}