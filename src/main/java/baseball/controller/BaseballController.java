package baseball.controller;

import baseball.domain.Baseball;
import baseball.service.Conversion;
import baseball.service.Validate;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final Baseball baseball;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController() {
        this.baseball = new Baseball();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        outputView.startMessage();
    }
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            isRunning = play();
        }
    }

    public boolean play() {
        baseball.computerNumbersGenerator();
        while (true) {
            String userInput = inputView.readBaseballNumbers();

            if (!Validate.validator(userInput)) {
                throw new IllegalArgumentException(); // 예외 발생
            }

            boolean endFlag = outputView.printMessage(baseball.compare(Conversion.stringToList(userInput)));

            while(endFlag) {
                outputView.endMessage();
                userInput = inputView.readCommandNumbers();
                int commandType = Validate.commandValidator(userInput);
                if(commandType == 1) {
                    return true;
                }
                else if(commandType == 2) {
                    return false;
                }
            }
        }
    }
}
