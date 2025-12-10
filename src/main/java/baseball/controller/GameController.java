package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Matches;
import baseball.exception.NoMatchResultException;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

/**
 * 프로그램의 전체 흐름을 조율하는 클래스
 */
public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService service;

    public GameController(InputView inputView, OutputView outputView, BaseballService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    };

    public void run() {
        outputView.printGameStartInstruction();
        boolean flag = false;
        do {
            startGame();
            outputView.printGameEndInstruction();
            flag = isStartingNewGame();
        } while (flag);
    }

    private void startGame() {
        Game game = service.createGame();
        boolean flag = false;
        do {
            boolean isGameOver = guess(game);
            flag = !isGameOver;
        } while (flag);
    }

    private boolean guess(Game game) {
        outputView.printNumberInputPrompt();
        String guessNumber = inputView.readGuessingNumber();
        try {
            Matches matchResult = service.match(game, guessNumber);
            outputView.printMatchResults(matchResult);
            return service.isGameOver(matchResult);
        } catch (NoMatchResultException e) {
            outputView.printMatchResults();
        }
        return false;
    }

    private boolean isStartingNewGame() {
        outputView.printGameProceedPrompt();
        String gameProceed = inputView.readGameProceed();
        return service.isStartingNewGame(gameProceed);
    }
}
