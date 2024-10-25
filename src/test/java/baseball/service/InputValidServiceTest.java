package baseball.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

class InputValidServiceTest {
    InputValidService inputValidService =new InputValidService();
    @Test
    void isInputValidTest(){
        //given
        String str = "123";
        //when
        boolean res = inputValidService.isInputValid(str);
        //then
        assertThat(res).isTrue();
    }
    @Test
    void isInputValidTest2(){
        //given
        String str = "1/3";
        //when
        boolean res = inputValidService.isInputValid(str);
        //then
        assertThat(res).isFalse();
    }
    @Test
    void isInputValidTEst3(){
        //given
        String str = "1";
        inputValidService.updateStatus();
        //when
        boolean res = inputValidService.isInputValid(str);
        //then
        assertThat(res).isTrue();
    }
    @Test
    void isInputValidTEst4(){
        //given
        String str = "=";
        inputValidService.updateStatus();
        //when
        boolean res = inputValidService.isInputValid(str);
        //then
        assertThat(res).isFalse();
    }

    @Test
    void updateStatusTest(){
        boolean res = inputValidService.endGame;
        inputValidService.updateStatus();
        assertThat(inputValidService.endGame).isEqualTo(!res);
    }

    @Test
    void continueOrEndGameTest(){
        //given
        String str = "1";
        //when
        boolean res = inputValidService.continueOrEndGame(str);
        //then
        assertThat(res).isTrue();
    }
    @Test
    void continueOrEndGameTest2(){
        //given
        String str = "2";
        //when
        boolean res = inputValidService.continueOrEndGame(str);
        //then
        assertThat(res).isFalse();
    }
}