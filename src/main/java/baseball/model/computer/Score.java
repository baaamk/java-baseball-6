package baseball.model.computer;

import java.util.List;

public class Score {

    private int balls;
    private int strikes;

    public int getBalls() {
        return balls;
    }

    public int getStrike() {
        return strikes;
    }

    public void validateAnswer(List<Integer> answer ,List<Integer> guess){
        balls=0;
        strikes=0;

        for(int i=0; i<answer.size(); i++){
            if(answer.get(i)==guess.get(i)) strikes++;
            for(int j=0; j<answer.size(); j++){
                if(answer.get(i)==guess.get(j) && i!=j) balls ++;
            }
        }
    }
    public void resetScore(){
        strikes=0;
        balls=0;
    }
}
