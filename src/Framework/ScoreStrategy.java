package Framework;

import java.util.List;

public interface ScoreStrategy {
    boolean calculateScore(char answer, char chosen, int secondsLeft);
    void showScore();
    List<String> returnResults();
}
