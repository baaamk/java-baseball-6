package baseball.view;

import baseball.domain.Matches;

/**
 * 프로그램의 모든 출력을 담당하는 인터페이스
 */
public interface OutputView {
    default void printGameStartInstruction() {};

    default void printNumberInputPrompt() {};

    default void printMatchResults() {};

    default void printMatchResults(Matches matchResult) {};

    default void printGameEndInstruction() {};

    default void printGameProceedPrompt() {};
}