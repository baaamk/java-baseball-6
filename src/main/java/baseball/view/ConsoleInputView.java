package baseball.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 프로그램의 콘솔 입력을 담당하는 클래스
 */
public class ConsoleInputView implements InputView {
    @Override
    public String readGuessingNumber() {
        return Console.readLine();
    }

    @Override
    public String readGameProceed() {
        return Console.readLine();
    }
}