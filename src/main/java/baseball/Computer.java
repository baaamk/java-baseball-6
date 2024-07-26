package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private int[] numbers;

    /**
     * 생성자
     */
    public Computer(){
        this.numbers = new int[3];
    }

    /**
     * 3개의 랜덤 숫자 생성
     */
    public void generateNumbers(){
        Set<Integer> generatedNumbers = new HashSet<>();
        int index = 0;

        // 3개를 뽑을 때 까지 반복
        while (generatedNumbers.size() < 3) {

            // 랜덤 수 뽑기
            int number = Randoms.pickNumberInRange(1, 9);

            // 중복된 수가 아닌 경우 배열에 추가
            if (!generatedNumbers.contains(number)) {
                this.numbers[index++] = number;
                generatedNumbers.add(number);
            }
        }
    }

    /**
     * 생성된 숫자 반환
     * @return
     */
    public int[] getNumbers(){
        return this.numbers;
    }

}
