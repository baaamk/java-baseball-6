package baseball.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

	private static final String startMessage = "숫자 야구 게임을 시작합니다.";
	private static final String inputMessage = "숫자를 입력해주세요 : ";

	private static final String retryMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final Scanner scanner = new Scanner(System.in);

	public static List<Integer> readUserInput() {
		inputMessage();
		String input = scanner.nextLine();
		return Stream.of(input.split(""))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public static int readRestartCommand() {
		displayRetryMessage();
		return Integer.parseInt(scanner.nextLine());
	}



	public static void startMessage() {
		System.out.println(startMessage);
	}

	public static void inputMessage() {
		System.out.print(inputMessage);
	}

	public static void displayRetryMessage() {
		System.out.println(retryMessage);
	}
}