package Framework;

import java.util.List;

public interface ScoreStrategy {
    boolean calculateScore(char answer, char chosen);
    void showScore();
    List<String> returnResults();
}
