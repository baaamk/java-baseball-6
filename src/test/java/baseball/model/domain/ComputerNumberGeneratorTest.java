package baseball.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ComputerNumberGeneratorTest {
    @Test
    @DisplayName("숫자 3개가 정상적으로 반환된다.")
    void 숫자_3개가_정상적으로_반환된다() {
        List<Integer> generatedNumber = ComputerNumberGenerator.generateNumber();
        Assertions.assertThat(generatedNumber.stream().count()).isEqualTo(3);
    }

}