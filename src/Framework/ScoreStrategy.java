package Framework;

public interface ScoreStrategy {
    void calculateScore(char answer, char chosen);
    void showScore();
}
