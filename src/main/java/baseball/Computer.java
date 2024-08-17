package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int startNum = 1;
	private static final int endNum = 9;
	private static List<Integer> pickedRandomList = new ArrayList<>();

	public static final Computer computer = new Computer();

	public static List<Integer> pickThreeRandomNumber() {
		while (pickedRandomList.size() < 3){
			int num = Randoms.pickNumberInRange(startNum, endNum);
			pickedRandomList.add(num);
		}
		return pickedRandomList;
	}

	private Computer() {
	}
}
