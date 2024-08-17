package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private List<Integer> inputNumList = new ArrayList<>();
	public static String inputNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		final String inputNum = Console.readLine();
		validateLength(inputNum);
		return inputNum;
	}

	private static void validateLength(final String inputNum){
		if(inputNum.length() != 3)
			throw new IllegalArgumentException();
	}
}
