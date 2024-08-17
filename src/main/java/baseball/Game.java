package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private int strikes;
	private int balls;
	private boolean nothing;
	private final List<Integer> playerNumList;
	private final List<Integer> computerNumList;

	private static final int ZERO = 0;

	private static final int THREE = 3;

	private static final Integer moreGame = 1;

	private void playGame() {
		for (int i = 0; i < playerNumList.size(); i++) {
			for(int j = 0; j < computerNumList.size(); j++){
				checkStrike(i, j);
				checkBall(i, j);
			}
		}
		checkNothing();
	}

	private void checkStrike(int playerNumIndex, int computerNumIndex){
		if(playerNumIndex == computerNumIndex &&
			playerNumList.get(playerNumIndex).equals(computerNumList.get(computerNumIndex))){
			strikes ++;
		}
	}

	private void checkBall(int playerNumIndex, int computerNumIndex){
		if(playerNumIndex != computerNumIndex &&
			playerNumList.get(playerNumIndex).equals(computerNumList.get(computerNumIndex))){
			balls ++;
		}
	}

	private void checkNothing(){
		nothing = (strikes == ZERO && balls == ZERO);
	}

	public boolean isSuccess() {
		return strikes == THREE;
	}

	private void printResult() {
		if(isSuccess()){
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		} else if (nothing) {
			System.out.println("낫싱");
		} else {
			System.out.println(balls + "볼 " + strikes + "스트라이크");
		}
	}

	private void printGameStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public boolean isMoreGame(){
		String input = Console.readLine();
		Integer inputNum = Integer.valueOf(input);
		return inputNum.equals(moreGame);
	}

	public void start(){
			printGameStart();
			playGame();
			printResult();

	}

	public Game(List<Integer> playerNumList, List<Integer> computerNumList) {
		this.strikes = 0;
		this.balls = 0;
		this.nothing = false;
		this.playerNumList = playerNumList;
		this.computerNumList = computerNumList;
	}
}
