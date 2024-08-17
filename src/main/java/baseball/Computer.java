package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int startNum = 1;
	private static final int endNum = 9;
	private List<Integer> pickedRandomList = new ArrayList<>();

	public static final Computer computer = new Computer();

	public void setPickedRandomList() {
		List<Integer> tempRandomList = new ArrayList<>();
		while (tempRandomList.size() < 3){
			int num = Randoms.pickNumberInRange(startNum, endNum);
			tempRandomList.add(num);
		}
		this.pickedRandomList = tempRandomList;
	}

	public List<Integer> getPickedRandomList(){
		return pickedRandomList; 
	}

	private Computer() {
	}
}
