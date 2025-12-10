package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.Game;
import baseball.domain.Match;
import baseball.domain.Matches;
import baseball.util.NumberGenerator;
import baseball.util.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballServiceTest {
    @Nested
    class SuccessTest {
        @DisplayName("게임을 정상적으로 생성한다")
        @Test
        void should_Return_Game() {
            // given
            NumberGenerator numberGenerator = new RandomNumberGenerator();
            BaseballService service = new BaseballService(numberGenerator);

            // when & then
            assertThat(service.createGame()).isNotNull()
                    .isInstanceOf(Game.class);
        }
        
        @DisplayName("게임 결과를 계산한다")
        @Test
        void should_Return_Matches() {
            // given
            BaseballNumber answer = BaseballNumber.from("123");
            Game game = new Game(answer);
            NumberGenerator numberGenerator = new NumberGenerator() {
                @Override
                public List<Integer> generateUniqueNumbersInRange(int size, int start, int end) {
                    return List.of(1,2,3);
                }
            };
            BaseballService service = new BaseballService(numberGenerator);

            // when
            Matches matches = service.match(game, "123");

            // then
            assertThat(matches.getMatchCount(Match.STRIKE)).isEqualTo(3);
            assertThat(matches.getMatchCount(Match.BALL)).isEqualTo(0);
        }
    }
}
