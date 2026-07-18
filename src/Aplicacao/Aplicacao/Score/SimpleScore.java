package Aplicacao.Score;

import Framework.*;

import java.util.ArrayList;
import java.util.List;

public class SimpleScore implements ScoreStrategy {
    int correct = 0;
    int total = 0;
    @Override
    public boolean calculateScore(char answer, char chosen, int secondsLeft) {
        if(answer == chosen) {
            total++;
            correct++;
            return true;
        }else{
            total++;
            return false;
        }
    }

    @Override
    public void showScore() {
        System.out.println("Score final: " + correct + "/" + total);
        System.out.println("Respostas corretas: " + correct);
        System.out.println("Respostas incorretas: " + (total - correct));
    }

    @Override
    public List<String> returnResults() {
        List<String> results = new ArrayList<>();
        results.add("Resultado final: " + correct + "/" + total);
        results.add("Respostas corretas: " + correct);
        results.add("Respostas incorretas: " + (total - correct));
        return results;
    }
}
