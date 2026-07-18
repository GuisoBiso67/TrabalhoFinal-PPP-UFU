package Aplicacao.WCQuiz;

import Aplicacao.Score.SimpleScore;
import Framework.QuizFactory;
import Framework.QuizTemplate;

public class Main {
    public static void main(String[] args) {

        QuizFactory WCFactory = new QuizFactoryWC();
        QuizTemplate WC = WCFactory.criarQuiz();
        WC.setScoreStrategy(new SimpleScore());
        WC.quiz();
    }
}
