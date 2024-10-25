package baseball.controller;

import baseball.model.RandomPickData;
import baseball.model.UserInputData;
import baseball.service.InputValidService;
import baseball.service.Service;
import baseball.view.UserViewResponse;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.view.UserViewResponse.*;

public class UserViewController {
    UserInputData userInputData;
    InputValidService inputValidService = new InputValidService();
    Service service = new Service();
    static RandomPickData randomPickData;

    //(1) view의 상태를 application에 전달
    public void start(){
        START_GAME_MESSAGE();
    }

    //(2) 사용자의 입력값을 모델에 저장
    public void userInput(String str){
        randomPickData = new RandomPickData();
        userInputData = new UserInputData();
        userInputData.setStr(str);

        //입력값의 유효성 판단
        while(inputValidService.isStrikeAll()){
            String input = getInput();
            if(inputValidService.isInputValid(input)){
                String res = service.judgement(input, getRandomPicks());
                JUDGEMENT_MESSAGE(res);
            }else{
                EXCEPTION_MESSAGE(); break;
            }
            if(inputValidService.isStrikeAll()){
                continueOrEndGame();
                break;
            }
            userInputData.setStr(Console.readLine());
        }
    }

    private void continueOrEndGame(){
        END_GAME_MESSAGE();
        String ctn = Console.readLine();
        if(inputValidService.isInputValid(ctn)){
            if(inputValidService.continueOrEndGame(ctn)){
                String newInput = Console.readLine();
                userInput(newInput);
            }else{
                System.out.println();
            }
        }else{
            EXCEPTION_MESSAGE();
        }
    }

    public String getInput(){
        return userInputData.getStr();
    }

    public List<String> getRandomPicks(){
        return randomPickData.getRandomList();
    }
}
