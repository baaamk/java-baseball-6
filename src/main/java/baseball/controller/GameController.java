package baseball.controller;

import baseball.domain.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    public void start(GameResult gameResult,
                      InputView inputView,
                      OutputView outputView) {

        // 컴퓨터가 숫자 생성
        List<Integer> computer = createNumbers();

        while(true) {
            // 게임 결과 초기화
            gameResult.reset();

            System.out.println("확인용: " + computer);
            // 사용자 입력
            String input = inputView.requestNumbers();
            List<Integer> player = convertToIntegerList(input);

            // 비교
            compareNumbers(computer, player, gameResult);

            outputView.hintMessage(gameResult.getBall(), gameResult.getStrike());

            if (gameResult.getStrike() == 3) {
                outputView.successMessage();
                int retryOrFinish = inputView.requestRetryOrFinish();
                if (retryOrFinish == 1) {
                    computer = createNumbers();
                    continue;
                }
                return;
            }
        }
    }

    // input String -> List<Integer>로 바꾸기
    public List<Integer> convertToIntegerList(String input) {
        int[] arr = Arrays.stream(input.split(""))
            .mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

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
