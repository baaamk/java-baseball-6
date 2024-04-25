package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallStrikeEvaluator {
    public Map<String, Integer> evaluate(List<Integer> answer, List<Integer> userBalls){

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < userBalls.size(); j++) {
                if (answer.get(i) == userBalls.get(j) && i == j ) { // 인덱스 위치가 같고, 숫자가 같으면 스트라이크
                    strike++;
                } else if(answer.get(i) == userBalls.get(j) && i != j) { // 숫자만 같으면 볼
                    ball++;
                }
            }
        }

        Map<String, Integer> result = new HashMap<>();
        result.put("strike", strike);
        result.put("ball", ball);
        return result;
    }
}
