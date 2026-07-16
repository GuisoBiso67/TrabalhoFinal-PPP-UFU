package Aplicacao;

import Aplicacao.ProgQuiz.*;
import Aplicacao.WCQuiz.*;
import Framework.*;

public class Main {
    public static void main(String[] args) {
        /*
        QuizFactory WCFactory = new QuizFactoryWC();
        QuizTemplate WC = WCFactory.criarQuiz();
        WC.setScoreStrategy(new TimeBasedScore());
        WC.quiz();*/

        QuizFactory CodFactory = new QuizFactoryCod();
        QuizTemplate Cod = CodFactory.criarQuiz();
        Cod.setScoreStrategy(new SimpleScore());
        Cod.quiz();
    }
}
