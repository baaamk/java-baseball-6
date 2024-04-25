package baseball;

import java.util.List;
import java.util.Map;

public class BaseBallGame {

    void play() {

        OutputView outputView1 = new OutputView();
        outputView1.startMessage();

        // 컴퓨터 세자리 숫자 랜덤 생성
        NumberGenerator playComputer = new NumberGenerator();
        List<Integer> randomNumber = playComputer.makeThreeRandomNumber();

        int replay = 0;

        while(replay != 2) {

            if(replay == 1) {
                playComputer = new NumberGenerator();
                randomNumber = playComputer.makeThreeRandomNumber();
            }

            InputView inputView = new InputView();
            List<Integer> inputNumbers = inputView.inputNumbers();

            BallStrikeEvaluator evaluator = new BallStrikeEvaluator();
            Map<String, Integer> evaluate = evaluator.evaluate(randomNumber, inputNumbers);// 볼, 스트라이크 판단

            OutputView outputView = new OutputView(); // strike, ball 개수 판단
            outputView.printResult(evaluate);

            //3스트라이크가 아니면 다시 입력해 주세요
            if(evaluate.get("strike") == 3) {
                replay = inputView.selectNewGameOrQuitGame();

            }
        }
    }
}
