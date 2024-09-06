package baseball.domain;

import java.util.List;

public class User {
    private final Numbers userNumbers;

    public User(Numbers userNumbers) {
        this.userNumbers = userNumbers;
    }
    public List<Integer> getUserNumbers() {
        return userNumbers.getNumbers();
    }
}
