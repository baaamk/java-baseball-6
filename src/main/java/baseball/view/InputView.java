package baseball.view;

import baseball.model.computer.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String printRestartMessage(){
        System.out.println(RESTART_MESSAGE);
        String restart = readLine();
        return restart;
    }

    public String printInputMessage(){
        System.out.println(INPUT_MESSAGE);
        String input = readLine();
        return input;
    }
}
