package Aplicacao;

import Framework.*;

public class Main {
    public static void main(String[] args) {
        QuizFactory WCFabrica = new QuizFactoryWC();
        QuizTemplate WC = WCFabrica.criarQuiz();
        WC.setScoreStrategy(new TimeBasedScore());
        WC.quiz();
    }
}
