package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private int[] numbers;

    public Computer(){
        this.numbers = new int[3];
    }

    public void generateNumbers(){
        Set<Integer> generatedNumbers = new HashSet<>();
        int index = 0;

        while (generatedNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(number)) {
                this.numbers[index++] = number;
                generatedNumbers.add(number);
            }
        }
    }

    public int[] getNumbers(){
        return this.numbers;
    }

}
