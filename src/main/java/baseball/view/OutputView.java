package baseball.view;

import baseball.controller.dto.ResultMapper;

public class OutputView {
    public void printStartNotice() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputNotice() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public void printFinalInformation() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRetryInformation() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printResult(ResultMapper mappedResult) {
        chooseResult(mappedResult);
    }

    private static void chooseResult(ResultMapper mappedResult) {
        if (mappedResult.ball() == 0 && mappedResult.strike() == 0) {
            System.out.println("낫싱");
            return;
        }
        if (mappedResult.ball() == 0) {
            System.out.println(mappedResult.strike() + "스트라이크");
            return;
        }
        if (mappedResult.strike() == 0) {
            System.out.println(mappedResult.ball() + "볼");
            return;
        }
        System.out.println(mappedResult.ball() + "볼 " + mappedResult.strike() + "스트라이크");
    }

}
