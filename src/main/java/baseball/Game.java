package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private int strikes;
	private int balls;
	private boolean nothing;
	private List<Integer> playerNumList = new ArrayList<>();
	private List<Integer> computerNumList = new ArrayList<>();

	private static final int ZERO = 0;

	private static final int THREE = 3;

	public void playGame() {
		for (int i = 0; i <= playerNumList.size(); i++) {
			for(int j = 0; j <= computerNumList.size(); j++){
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

	private boolean isSuccess() {
		return strikes == THREE;
	}

	public void printResult() {
		if(isSuccess()){
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		} else if (nothing) {
			System.out.println("낫싱");
		} else {
			System.out.println(balls + "볼 " + strikes + "스트라이크");
		}
	}

	public Game(List<Integer> playerNumList, List<Integer> computerNumList) {
		this.playerNumList = playerNumList;
		this.computerNumList = computerNumList;
	}
}
