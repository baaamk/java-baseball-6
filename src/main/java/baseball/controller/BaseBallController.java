package baseball.controller;

import baseball.model.GameProgress;
import baseball.model.GameResult;
import baseball.model.RandomNumberGenerator;
import baseball.model.UserNumber;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

public class BaseBallController {

    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameProgress gameProgress;

    public BaseBallController(ConsoleInput consoleInput, ConsoleOutput consoleOutput,
                              RandomNumberGenerator randomNumberGenerator, GameProgress gameProgress) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.randomNumberGenerator = randomNumberGenerator;
        this.gameProgress = gameProgress;
    }

    public void run() {
        consoleOutput.printStartMessage();

        do {
            playGame();
        } while (isRestart());
    }

    private void playGame() {
        String computerNumber = randomNumberGenerator.generateRandomNumber();

        while (true) {
            consoleOutput.printUserInputMessage();
            String userInput = consoleInput.userInput();
            UserNumber userNumber = UserNumber.of(userInput);

            GameResult process = gameProgress.process(computerNumber, userNumber);
            consoleOutput.printGameMessage(process);

            if (process.isThreeStrike()) {
                consoleOutput.printResultMessage();
                break;
            }

        }
    }

    private boolean isRestart() {
        consoleOutput.printRestartMessage();
        String restart = consoleInput.userInput();
        return "1".equals(restart);
    }

}
