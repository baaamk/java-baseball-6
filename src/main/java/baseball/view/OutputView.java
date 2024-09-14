package baseball.view;

public class OutputView {

    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean printMessage(String message) {
        System.out.println(message);
        boolean threeStrikeFlag = false;
        if(message.equals("3스트라이크")) {
            threeStrikeFlag = true;
        }

        return threeStrikeFlag;
    }
}
