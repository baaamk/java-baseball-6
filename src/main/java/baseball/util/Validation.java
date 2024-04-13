package baseball.util;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Validation {

	private static final Scanner scanner = new Scanner(System.in);

	public static List<Integer> readUserInput() {
		InputView.inputMessage();
		String input = scanner.nextLine();
		return parseInput(input);
	}

	public static int readRestartCommand() {
		InputView.displayRetryMessage();
		return Integer.parseInt(scanner.nextLine());
	}


	private static List<Integer> parseInput(String input) {
		return Stream.of(input.split(""))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public static String calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
		int strikes = 0;
		int balls = 0;
		for (int i = 0; i < computerNumbers.size(); i++) {
			if (computerNumbers.get(i).equals(userNumbers.get(i))) {
				strikes++;
			} else if (userNumbers.contains(computerNumbers.get(i))) {
				balls++;
			}
		}
		if (strikes == 0 && balls == 0) {
			OutputView.nothingMessage();
		}
		return (balls > 0 ? balls + "볼" : "") + (strikes > 0 ? strikes + "스트라이크" : "").trim();
	}
}
