package baseball.view;

public class OutputView {
	private static final String endMessage = "%s개의 숫자를 모두 맞히셨습니다! 게임 종료%n";

	private static final String strike = "스트라이크";
	private static final String ball = "볼";
	private static final String nothing = "낫싱";


	public static void displayResult(String result) {
		System.out.println(result);
	}

	public static void displayGameWonMessage() {
		System.out.println(endMessage);
	}

	public static void strikeMessage() {
		System.out.print(strike);
	}

	public static void ballMessage() {
		System.out.print(ball);
	}

	public static void nothingMessage() {
		System.out.print(nothing);
	}






}
