package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    // 기능: 컴퓨터의 서로 다른 세자리 숫자 선택
    public List<Integer> makeThreeRandomNumber() {

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        System.out.println(randomNumbers);
        return randomNumbers;
    }
}
