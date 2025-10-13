package baseball.view;

public class OutputView {
    // 처음 한 번에만 나오므로 제외
//    public void startMessage() {
//        System.out.println("숫자 야구 게임을 시작합니다.");
//    }

    public void hintMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball != 0)
            System.out.print(ball + "볼 ");

        if (strike != 0)
            System.out.println(strike + "스트라이크");
    }

    public void successMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
