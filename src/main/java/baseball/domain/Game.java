package baseball.domain;

import java.util.List;

/**
 * 게임 상태 관리를 담당하는 클래스
 */
public class Game {
    private final BaseballNumber answer;

    public Game(BaseballNumber answer) {
        this.answer = answer;
    }

    public List<Match> matchWithAnswer(BaseballNumber number) {
        return answer.match(number);
    }
}
