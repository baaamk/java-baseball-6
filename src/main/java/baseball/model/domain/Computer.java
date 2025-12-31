package baseball.model.domain;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.List;

public class Computer {
    private final List<Integer> computer;

    private Computer(List<Integer> computer) {
        this.computer = computer;
    }

    public static Computer generateNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new Computer(computer);
    }

}
