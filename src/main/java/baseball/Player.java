package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void savePlayerNumber(String numberString) {
        clear(); // 초기화

        for (char number : numberString.toCharArray()) {
            if (!valid(number)) {
                throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 수가 아닙니다.");
            }
            numbers.add(Character.getNumericValue(number));
        }
    }

    private boolean valid(char number) {
        // 3자리 보다 많은 수를 입력한 경우
        if (numbers.size() == 3) {
            return false;
        }
        // 1~9까지 숫자가 아닌 경우
        if (!Character.isDigit(number)) {
            return false;
        }
        // 중복된 숫자인 경우
        if (numbers.contains(Character.getNumericValue(number))) {
            return false;
        }

        return true;
    }

    private void clear() {
        numbers.clear();
    }
}
