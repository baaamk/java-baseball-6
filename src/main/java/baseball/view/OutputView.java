package baseball.view;

import baseball.model.computer.RandomNumberGenerator;
import baseball.model.computer.Score;

public class OutputView {
    private static final String WIN_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임종료";
    public void printScore(Score score){
        int ball = score.getBalls();
        int strike = score.getStrike();

        if(ball == 0 && strike==0) {
            System.out.println("낫싱");
        }else if(strike == RandomNumberGenerator.NUMBER_LENGTH){
            System.out.println(strike+"스트라이크");
            System.out.println(String.format(WIN_MESSAGE,RandomNumberGenerator.NUMBER_LENGTH));
        }else if(ball==0){
            System.out.println(strike+"스트라이크");
        }else if(strike==0){
            System.out.println(ball+"볼");
        }else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }


    }
}
