package baseball.view;

import baseball.domain.Match;
import baseball.domain.Matches;

/**
 * 프로그램의 콘솔 출력을 담당하는 클래스
 */
public class ConsoleOutputView implements OutputView {
    @Override
    public void printGameStartInstruction() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    };

    @Override
    public void printNumberInputPrompt() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printMatchResults() {
        System.out.println("낫싱");
    }

    @Override
    public void printMatchResults(Matches matches) {
        for (Match match : Match.values()) {
            int count = matches.getMatchCount(match);
            if (count > 0) {
                printMatchResult(match, count);
            }
        }
        System.out.println();
    }

    @Override
    public void printGameEndInstruction() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    };

    @Override
    public void printGameProceedPrompt() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void printMatchResult(Match match, int count) {
        System.out.printf("%d%s ", count, match.getMessage());
    }
}
