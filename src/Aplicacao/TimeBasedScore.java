package Aplicacao;

import Framework.ScoreStrategy;
import java.util.ArrayList;
import java.util.List;

public class TimeBasedScore implements ScoreStrategy {
    private int totalScore = 0;
    private List<String> history = new ArrayList<>();
    private int questionCount = 1;

    @Override
    public boolean calculateScore(char answer, char chosen, int secondsLeft) {
        boolean correct = (answer == chosen);
        if (correct) {
            // ganha pontos base + bonus por segundo restante;
            int pointsEarned = 10 + secondsLeft;
            totalScore += pointsEarned;
            history.add("Questão " + questionCount + ": Acertou! Ganhou " + pointsEarned + " pontos. (Tempo restante: " + secondsLeft + "s)");
        } else {
            int pointsLost = secondsLeft/2;
            history.add("Questão " + questionCount + ": Errou! Perdeu " + pointsLost + " pontos.");
            totalScore -= pointsLost;
        }
        questionCount++;
        return correct;
    }

    @Override
    public void showScore() {
        System.out.println("Pontuação Total: " + totalScore);
    }

    @Override
    public List<String> returnResults() {
        List<String> results = new ArrayList<>(history);
        results.add("Pontuação Final Total: " + totalScore);
        return results;
    }
}
