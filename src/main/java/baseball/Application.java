package baseball;

import baseball.controller.BaseBallController;
import baseball.model.GameProgress;
import baseball.model.RandomNumberGenerator;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {

        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        GameProgress gameProgress = new GameProgress();

        BaseBallController baseBallController = new BaseBallController(
                consoleInput,
                consoleOutput,
                randomNumberGenerator,
                gameProgress
        );

        baseBallController.run();
    }
}
