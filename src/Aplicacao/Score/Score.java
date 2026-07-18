package Aplicacao.Score;

import Framework.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Score implements ScoreStrategy {
    int correct = 0;
    int incorrect = 0;
    @Override
    public boolean calculateScore(char answer, char chosen, int secondsLeft) {
        if(answer == chosen) {
            correct += 10;
            return true;
        }else{
            incorrect -= 10;
            return false;
        }
    }

    @Override
    public void showScore() {
        int qtd_correct = correct/10;
        int qtd_incorrect = abs(incorrect/10);
        System.out.println("Score final:" + (correct+incorrect));
        System.out.println("Respostas corretas: " + qtd_correct);
        System.out.println("Respostas incorretas: " + qtd_incorrect);
    }

    @Override
    public List<String> returnResults() {
        int qtd_correct = correct/10;
        int qtd_incorrect = abs(incorrect/10);
        List<String> results = new ArrayList<>();
        results.add("Resultado final: " + (correct+incorrect));
        results.add("Respostas corretas: " + qtd_correct);
        results.add("Respostas incorretas: " + qtd_incorrect);
        return results;
    }
}
