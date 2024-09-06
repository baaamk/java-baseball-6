package baseball.domain;

import static baseball.domain.Computer.compareNumbers;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ComputerTest {
    private static Computer computerNumbers;
    private static User user;

    @BeforeEach
    void setUp() {
        // 예시로 컴퓨터가 선택한 3자리 숫자를 설정
        computerNumbers = new Computer(new Numbers(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("3 스트라이크 테스트")
    void compareNumbersIsTrueTest() {
        user = new User(new Numbers(Arrays.asList(1, 2, 3)));
        assertTrue(compareNumbers(user));
    }


    @DisplayName("3볼, 스트라이크,볼 혼합, 전혀다른경우 테스트")
    @ParameterizedTest
    @MethodSource("provideUserNumbers")
    void compareNumbersIsFalseTest() {
        user = new User(new Numbers(Arrays.asList(3, 1, 2)));
        assertFalse(compareNumbers(user));
    }
    static Stream<List<Integer>> provideUserNumbers() {
        return Stream.of(
                Arrays.asList(3, 1, 2),  // 3 볼
                Arrays.asList(1, 3, 2),  // 2 스트라이크, 1 볼
                Arrays.asList(4, 5, 6)  // 전혀 다른 경우.
        );
    }




    @Test
    @Disabled
    void resetNumbers() {
    }
}