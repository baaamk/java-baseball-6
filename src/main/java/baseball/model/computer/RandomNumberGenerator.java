package baseball.model.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static final Integer NUMBER_LENGTH = 3;

    public List<Integer> generateRandNum(){
        List<Integer> number = new ArrayList<>();
        while(number.size()< NUMBER_LENGTH){
            int randNum = Randoms.pickNumberInRange(1,9);
            if(!number.contains(randNum)) number.add(randNum);
        }
        return number;
    }

}
