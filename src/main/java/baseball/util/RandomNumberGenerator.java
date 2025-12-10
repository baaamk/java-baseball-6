package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateUniqueNumbersInRange(int size, int start, int end) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < size) {
            numbers.add(Randoms.pickNumberInRange(start, end));
        }

        return numbers.stream().toList();
    }
}
