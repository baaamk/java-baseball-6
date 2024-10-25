package baseball.controller;

import baseball.model.RandomPickData;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserViewControllerTest {
    RandomPickData randomPickData;
    @Test
    void userInputTest(){
        //given
        String str = "123";
        randomPickData = new RandomPickData();
        List<String> ls = randomPickData.getRandomList();
        //when
        //then
    }

}