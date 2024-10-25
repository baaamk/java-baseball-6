package baseball.service;

import baseball.model.RandomPickData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    RandomPickData randomPickData = new RandomPickData();
    Service service = new Service();

    @Test
    void judgementTest(){
        //given
        String str = "123";
        List<String> ls = randomPickData.getRandomList();
        //when
        String res = service.judgement(str, ls);
        for(int i=0; i<3; i++){
            ls.get(i);
        }
        //then
        assertThat(res).isNotNull();
    }
    @Test
    void judgementTest2(){
        //given
        String str = "123";
        List<String> ls = new ArrayList<>();
        for(int i=0; i<3; i++){
            ls.add(str.substring(i,i+1));
        }
        //when
        String res = service.judgement(str, ls);
        //then
        assertThat(res).isEqualTo("3스트라이크 ");
    }

}