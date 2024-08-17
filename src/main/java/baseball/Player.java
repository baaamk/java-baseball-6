package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public static void inputNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		final String inputNum = Console.readLine();
	}

	private static void validateLength(final String inputNum){
		if(inputNum.length() != 3)
			throw new IllegalArgumentException();
	}
}
