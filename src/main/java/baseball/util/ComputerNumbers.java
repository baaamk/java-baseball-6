package baseball.util;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumbers {

	public static List<Integer> generateNumbers(int size) {
		List<Integer> tempNumbers = new ArrayList<>();
		while (tempNumbers.size() < size) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!tempNumbers.contains(randomNumber)) {
				tempNumbers.add(randomNumber);
			}
		}
		return tempNumbers;
	}
}