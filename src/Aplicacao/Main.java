package Aplicacao;

import Framework.*;

public class Main {
    public static void main(String[] args) {
        QuizFactory GKFabrica = new QuizFactoryGK();
        QuizTemplate GK = GKFabrica.criarQuiz();
        GK.setScoreStrategy(new SimpleScore());
        GK.quiz();
    }
}
