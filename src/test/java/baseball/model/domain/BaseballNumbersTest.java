package baseball.model.domain;

import baseball.model.domain.vo.BaseballNumber;
import baseball.utils.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BaseballNumbersTest {

    @Test
    @DisplayName("번호가 동일하면 스트라이크3을 반환한다.")
    void 번호가_동일하면_스트라이크3을_반환한다() {
        BaseballNumbers targetNumbers = BaseballNumbers.of(List.of(1, 2, 3));
        BaseballNumbers userNumbers = BaseballNumbers.of(List.of(1, 2, 3));

        Result result = targetNumbers.compareNumber(userNumbers);

        Assertions.assertTrue(result.isStrike(3));
        Assertions.assertTrue(result.isBall(0));

    }

    @Test
    @DisplayName("번호가 위치가 하나가 같고 두개는 위치만 다르면 스트라이크 1 볼 2를 반환한다")
    void 번호가_위치가_하나가_같고_두개는_위치만_다르면_스트라이크_1_볼_2를_반환한다() {
        BaseballNumbers targetNumbers = BaseballNumbers.of(List.of(1, 2, 5));
        BaseballNumbers userNumbers = BaseballNumbers.of(List.of(1, 5, 2));

        Result result = targetNumbers.compareNumber(userNumbers);

        Assertions.assertTrue(result.isStrike(1));
        Assertions.assertTrue(result.isBall(2));
    }

    @Test
    @DisplayName("번호가 위치가 하나가 같고 한개는 위치만 다르고 나머지는 다른 숫자면 스트라이크 1 볼 1를 반환한다")
    void 번호가_위치가_하나가_같고_한개는_위치만_다르고_나머지는_다른_숫자면_스트라이크_1_볼_1를_반환한다() {
        BaseballNumbers targetNumbers = BaseballNumbers.of(List.of(1, 2, 6));
        BaseballNumbers userNumbers = BaseballNumbers.of(List.of(1, 5, 2));

        Result result = targetNumbers.compareNumber(userNumbers);

        Assertions.assertTrue(result.isStrike(1));
        Assertions.assertTrue(result.isBall(1));
    }

    @Test
    @DisplayName("번호가 다 다르면 nothing 반환한다.")
    void 번호가_다_다르면_nothing_반환한다() {
        BaseballNumbers targetNumbers = BaseballNumbers.of(List.of(1, 2, 5));
        BaseballNumbers userNumbers = BaseballNumbers.of(List.of(3, 4, 7));

        Result result = targetNumbers.compareNumber(userNumbers);

        Assertions.assertTrue(result.isNothing());
    }

    @Test
    @DisplayName("번호가 범위에 들어오지 않으면 예외로 처리한다.")
    void 번호가_범위에_들어오지_않으면_예외로_처리한다() {
        assertThatThrownBy(() -> BaseballNumbers.of(List.of(3, 4, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DUPLICATE_NUMBER.getMessage());
    }
}