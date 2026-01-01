package baseball.view.parser;

import baseball.converter.parser.StringParser;
import baseball.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class StringParserTest {
    @Test
    @DisplayName("입력된 숫자가 정상적으로 반환된다.")
    void 입력된_숫자가_정상적으로_반환된다() {
        List<Integer> parsedToList = StringParser.parseToList("123");

        Assertions.assertThat(parsedToList).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("입력된 재시도 숫자가 정상적으로 반환된다.")
    void 입력된_재시도_숫자가_정상적으로_반환된다() {
        int retryNumber1 = StringParser.parseToInt("1");
        int retryNumber2 = StringParser.parseToInt("2");
        Assertions.assertThat(retryNumber1).isEqualTo(1);
        Assertions.assertThat(retryNumber2).isEqualTo(2);
    }

    @Test
    @DisplayName("입력된 숫자가 범위를 벗어났다.")
    void 입력된_숫자가_범위를_어났다() {
        assertThatThrownBy(() -> StringParser.parseToList("1230"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DUPLICATE_AND_RANGE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("입력된 숫자가 중복을 포함한다.")
    void 입력된_숫자가_중복을_포함한다() {
        assertThatThrownBy(() -> StringParser.parseToList("121"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DUPLICATE_AND_RANGE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("입력된 재시도 숫자가 범위를 벗어난다.1")
    void 입력된_재시도_숫자가_범위를_벗어난다1() {
        assertThatThrownBy(() -> StringParser.parseToInt("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_RETRY_NUMBER.getMessage());
    }

    @Test
    @DisplayName("입력된 재시도 숫자가 범위를 벗어난다.2")
    void 입력된_재시도_숫자가_범위를_벗어난다2() {
        assertThatThrownBy(() -> StringParser.parseToInt("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_RETRY_NUMBER.getMessage());
    }

    @Test
    @DisplayName("입력된 재시도 숫자가 공백이다.")
    void 입력된_재시도_숫자가_공백이다() {
        assertThatThrownBy(() -> StringParser.parseToInt(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_RETRY_NUMBER.getMessage());
    }



}