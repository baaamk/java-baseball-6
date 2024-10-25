package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomPickData {
    private List<String> randomList = new ArrayList<>();

    public RandomPickData(){
        randomPick();
    }

    private void randomPick(){
        String random = "";
        for(int i=0; i<3; i++){
            while(true){
                random = String.valueOf(Randoms.pickNumberInRange(1,9));
                if(!randomList.contains(random)){
                    break;
                }
            }
            this.randomList.add(random);
        }

    }

    public List<String> getRandomList(){
        return randomList;
    }
}
