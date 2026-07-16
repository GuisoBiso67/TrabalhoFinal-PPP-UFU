package Aplicacao.Coding;

import Aplicacao.WorldCup.QuizFactoryWC;
import Aplicacao.WorldCup.TimeBasedScore;
import Framework.QuizFactory;
import Framework.QuizTemplate;

public class Main {
    public static void main(String[] args) {
        QuizFactory CodFabrica = new QuizFactoryCod();
        QuizTemplate Cod = CodFabrica.criarQuiz();
        Cod.setScoreStrategy(new TimeBasedScore());
        Cod.quiz();
    }
}
