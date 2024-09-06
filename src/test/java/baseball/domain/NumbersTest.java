package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import javax.swing.JMenuBar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {
    private Numbers randomNumbers;

    @BeforeEach
    void setUpRandomNumbers() {
        randomNumbers  = Numbers.createRandomNumber();
    }

    @Test
    @DisplayName("3자리 난수 생성 성공 테스트")
    void createRandomNumberSuccess() {
        //given
        //when
        //then
        assertThat(randomNumbers).isNotNull();
    }
    @Test
    @DisplayName("생성된 난수가 3자리수인지 확인")
    void createRandomNumber_ThreeDigits() {
        //given
        //when
        List<Integer> numbers = randomNumbers.getNumbers();
        //then
        assertThat(numbers).hasSize(3);
    }
    @Test
    @DisplayName("생성된 난수에 중복된값이 있는지 확인")
    void createRandomNumber_NoDuplicates() {
        //given
        //when
        List<Integer> numbers = randomNumbers.getNumbers();
        //then
        assertThat(numbers).doesNotHaveDuplicates(); // 숫자가 중복되지 않고 모두 다른지 확인
    }

}