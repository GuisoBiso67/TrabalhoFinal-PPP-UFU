package Aplicacao;

import Framework.*;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.setScoreStrategy(new SimpleScore());
        quiz.quiz();
    }
}
