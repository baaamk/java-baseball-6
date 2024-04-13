package baseball.controller;

import java.util.List;

import baseball.service.BaseballService;
import baseball.util.ComputerNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

	private final BaseballService baseballService;

	public BaseballController() {
		this.baseballService = new BaseballService(new ComputerNumbers());
	}

	public void run() {
		InputView.startMessage();
		baseballService.startGame();
		playGame();
	}

	private void playGame() {
		boolean gameWon = false;
		while (!gameWon) {
			List<Integer> userInput = InputView.readUserInput();
			String result = baseballService.playGame(userInput);
			OutputView.displayResult(result);

			if (result.equals("3스트라이크")) {
				OutputView.displayGameWonMessage();
				if (!handleGameRestart()) {
					break;
				}
				baseballService.startGame();
			}
		}
	}

	private boolean handleGameRestart() {
		InputView.displayRetryMessage();
		int command = InputView.readRestartCommand();
		return command == 1;
	}
}
