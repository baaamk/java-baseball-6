package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
	private List<Integer> numbers;
	public Baseball(List<Integer> numbers) {
		this.numbers = numbers;
	}
	public List<Integer> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public Baseball() {
		numbers = new ArrayList<>();
	}



}
