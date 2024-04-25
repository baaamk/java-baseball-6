package baseball;

import java.util.Map;

public class OutputView {
    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    //역할: 스트라이크, 볼, 낫싱을 반환하는 역할
    public void printResult(Map<String, Integer> result) {
        Integer strike = result.getOrDefault("strike", 0);
        Integer ball = result.getOrDefault("ball", 0);

        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if (ball != 0 && strike == 0) {
            System.out.print(ball + "볼");
        }
        if (strike != 0 && ball == 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();

        if (strike == 3) {
            System.out.println();
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println();
        }
    }
}
