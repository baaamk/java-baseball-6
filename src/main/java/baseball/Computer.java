package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void createNumber() {
        if (numbers.size() == 3) {
            throw new IllegalCallerException("한 번 생성된 랜덤 3자리 숫자를 재생성 할 수 없습니다.");
        }

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public void clearNumber() {
        numbers.clear();
    }
}
