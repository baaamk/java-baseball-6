package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	public static final Player player = new Player(); 
	private List<Integer> inputNumList = new ArrayList<>();

	private String inputNum;

	public void inputNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		inputNum = Console.readLine();
		validateLength(inputNum);
	}

	private static void validateLength(final String inputNum){
		if(inputNum.length() != 3)
			throw new IllegalArgumentException();
	}

	public void changeToList(){
		String[] splitNum = inputNum.split("");
		inputNumList = Arrays.stream(splitNum)
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}

	public List<Integer> getInputNumList() {
		return inputNumList; 
	}

	private Player() {
	}
}
