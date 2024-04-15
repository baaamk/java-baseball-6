package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> number;

    public Computer() {
        number = new ArrayList<>();
    }

    public void generateNumber() {
        number.clear();
        while (number.size() < 3) {
            int rdnum = Randoms.pickNumberInRange(0, 9);
            if (!number.contains(rdnum)) {
                number.add(rdnum);
            }
        }
    }

    public boolean checkAnswer(List<Integer> playerNum) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (number.get(i).equals(playerNum.get(i))) {
                strike++;
            } else if (playerNum.contains(number.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("정답!");
            return true;
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }
            return false;
        }
    }
}
