package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> number;

    public Player() {
        number = new ArrayList<>();
    }

    public void guessNumber() {
        System.out.println("숫자 3개를 입력하세요 (0~9)");

        number.clear();

        for (int i = 0; i < 3; i++) {
            int num;
            try {
                num = Integer.parseInt(Console.readLine());
                if (num < 0 || num > 9) {
                    throw new IllegalArgumentException("0부터 9까지의 숫자만 입력하세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("올바른 숫자 범위를 벗어났습니다.");
                e.printStackTrace();
                return;
            }
            number.add(num);
        }
    }

    public List<Integer> getNumber() {
        return number;
    }
}
