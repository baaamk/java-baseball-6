package baseball.model.computer;

import java.util.List;

public class Computer {

    private List<Integer> answerNumber;
    private Score score;
    private RandomNumberGenerator randomNumberGenerator;

    public Computer(List<Integer> answerNumber, Score score, RandomNumberGenerator randomNumberGenerator) {
        this.answerNumber = answerNumber;
        this.score = score;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void makeAnswer(){
        answerNumber = randomNumberGenerator.generateRandNum();
    }

    public void validateAnswer(List<Integer> guess){
        score.validateAnswer(answerNumber, guess);
    }

    public Score getScore() {
        return score;
    }
}
