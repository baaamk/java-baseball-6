package baseball.service;

import java.util.List;
import baseball.domain.Baseball;
import baseball.util.ComputerNumbers;
import baseball.util.Validation;

public class BaseballService {
	private Baseball computer;
	private Baseball user;

	public BaseballService(ComputerNumbers computerNumbers) {
		List<Integer> numbers = ComputerNumbers.generateNumbers(3);
		this.computer = new Baseball(numbers);
		this.user = new Baseball();
	}

	public void startGame() {
		List<Integer> numbers = ComputerNumbers.generateNumbers(3);
		this.computer = new Baseball(numbers);
		this.user = new Baseball();
	}

	public String playGame(List<Integer> userNumbers) {
		this.user.setNumbers(userNumbers);
		return Validation.calculateResult(computer.getNumbers(), user.getNumbers());
	}

}
