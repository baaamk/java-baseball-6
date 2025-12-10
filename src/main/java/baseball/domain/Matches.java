package baseball.domain;

import java.util.EnumMap;
import java.util.List;

public class Matches {
    private final EnumMap<Match, Integer> matchCount;

    public Matches(EnumMap<Match, Integer> matchCount) {
        this.matchCount = matchCount;
    }

    public static Matches from(List<Match> matches) {
        EnumMap<Match, Integer> matchCount = new EnumMap<>(Match.class);
        for (Match match : matches) {
            matchCount.merge(match, 1, Integer::sum);
        }
        return new Matches(matchCount);
    }

    public int getMatchCount(Match match) {
        return matchCount.getOrDefault(match, 0);
    }
}
