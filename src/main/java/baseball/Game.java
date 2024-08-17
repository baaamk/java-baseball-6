package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private int strikes;
	private int balls;
	private boolean nothing;
	private List<Integer> playerNumList = new ArrayList<>();
	private List<Integer> computerNumList = new ArrayList<>();

	public void playGame() {
		for (int i = 0; i <= playerNumList.size(); i++) {
			for(int j = 0; j <= computerNumList.size(); j++){
				checkStrike(i, j);
				checkBall(i, j);
			}
		}
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

	public Game(List<Integer> playerNumList, List<Integer> computerNumList) {
		this.playerNumList = playerNumList;
		this.computerNumList = computerNumList;
	}
}
