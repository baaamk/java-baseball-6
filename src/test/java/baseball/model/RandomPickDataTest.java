package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomPickDataTest {
    @Test
    void test1(){
        List<String> randomList = new ArrayList<>();
        String res = "";
        for(int i=0; i<3; i++){
            while(true){
                int random = Randoms.pickNumberInRange(1,9);
                if(!randomList.contains(random)){
                    res = String.valueOf(random);
                    break;
                }
            }
            randomList.add(res);
        }
        assertThat(randomList).isNotNull();
    }

}