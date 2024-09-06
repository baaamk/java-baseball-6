package baseball.view;

import baseball.domain.Computer;

public class OutputView {


    public static void printGameResult(int strikes, int balls) {
        if (strikes == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }
        if (balls !=0 && strikes ==0 ) {
            System.out.println(balls+"볼");
        }
        if (balls ==0 && strikes !=0 ) {
            System.out.println(strikes+"스트라이크");
        }
        if (balls != 0 && strikes != 0) {
            System.out.println(balls +"볼 "+ strikes + "스트라이크");
        }
    }
}
