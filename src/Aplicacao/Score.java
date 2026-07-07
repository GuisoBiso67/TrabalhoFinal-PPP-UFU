package Aplicacao;

import Framework.*;

import static java.lang.Math.abs;

public class Score implements ScoreStrategy {
    int correct = 0;
    int incorrect = 0;
    @Override
    public void calculateScore(char answer, char chosen) {
        if(answer == chosen) {
            correct += 10;
        }else{
            incorrect -= 10;
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
}
