package baseball.view;

import baseball.model.GameResult;

public class ConsoleOutput {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printUserInputMessage() {
        System.out.print("숫자를 입력 해주세요: ");
    }

    public void printGameMessage(GameResult gameResult) {
        if (gameResult.isNoting()) {
            System.out.println("낫싱");
            return;
        }
        if (gameResult.isThreeStrike()) {
            System.out.println("3스트라이크");
            return;
        }
        System.out.println(gameResult.getBall() + "볼 " + gameResult.getStrike() + "스트라이크");
    }

    public void printResultMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
