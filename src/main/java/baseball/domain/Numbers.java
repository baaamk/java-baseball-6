package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public record Numbers(List<Integer> numbers) {
    public List<Integer> getNumbers() {
        return numbers;
    }
    public static Numbers createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (true) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
            if (numbers.size() == 3) {
                break;
            }
        }
        return new Numbers(numbers);
    }
}
