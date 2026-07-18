package Aplicacao.ProgQuiz;

import Aplicacao.Score.TimeBasedScore;
import Framework.*;

public class Main {
    public static void main(String[] args) {
        QuizFactory CodFactory = new QuizFactoryCod();
        QuizTemplate Cod = CodFactory.criarQuiz();
        Cod.setScoreStrategy(new TimeBasedScore());
        Cod.quiz();
    }
}
