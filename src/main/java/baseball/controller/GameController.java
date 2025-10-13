package baseball.controller;

import baseball.domain.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void start(GameResult gameResult,
                      InputView inputView,
                      OutputView outputView) {

        gameResult.reset();
        List<Integer> computer = createNumbers();
    }

    // input String -> List<Integer>로 바꾸기

    // 컴퓨터의 랜덤 3자리 수 생성
    public List<Integer> createNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {   // 확장성 고려해서 3을 상수로 바꾸기
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 볼, 스트라이크 판단 로직
    public void compareNumbers(List<Integer> computer,
                               List<Integer> player,
                               GameResult gameResult) {
        for (int i = 0; i < 3; i++) {
            int num = computer.get(i);
            if (num == player.get(i)) {
                gameResult.plusStrike();
                continue;
            }

            if (player.contains(num)) {
                gameResult.plusBall();
            }
        }
    }
}
