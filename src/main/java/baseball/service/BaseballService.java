package baseball.service;

import baseball.domain.Game;
import baseball.domain.BaseballNumber;
import baseball.domain.Match;
import baseball.domain.Matches;
import baseball.exception.*;
import baseball.util.InputParser;
import baseball.util.NumberGenerator;

import java.util.List;

import static baseball.domain.BaseballNumber.NUMBER_SIZE;
import static baseball.domain.BaseballNumber.NUMBER_MIN;
import static baseball.domain.BaseballNumber.NUMBER_MAX;

/**
 * 숫자 야구 게임 비즈니스 로직을 담당하는 클래스
 */
public class BaseballService {
    private final NumberGenerator numberGenerator;

    public BaseballService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Game createGame() {
        List<Integer> numbers = numberGenerator.generateUniqueNumbersInRange(NUMBER_SIZE, NUMBER_MIN, NUMBER_MAX);
        BaseballNumber answer = new BaseballNumber(numbers);
        return new Game(answer);
    }

    public Matches match(Game game, String guessString) {
        BaseballNumber guessNumber = BaseballNumber.from(guessString);
        List<Match> matches = game.matchWithAnswer(guessNumber);
        if (matches.isEmpty()) {
            throw new NoMatchResultException();
        }
        return Matches.from(matches);
    }

    public boolean isGameOver(Matches matches) {
        return matches.getMatchCount(Match.STRIKE) == NUMBER_SIZE;
    }

    public boolean isStartingNewGame(String gameProceed) {
        validateAnswer(gameProceed);
        return gameProceed.equals("1");
    }

    private void validateAnswer(String gameProceed) {
        try {
            int answer = InputParser.parseToInt(gameProceed);
            if (answer < 1 || answer > 2) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER.getMessage());
            }
        } catch (InputNullOrBlankException | InputNotNumericException | InputNumberOverflowException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER.getMessage());
        }
    }
}
