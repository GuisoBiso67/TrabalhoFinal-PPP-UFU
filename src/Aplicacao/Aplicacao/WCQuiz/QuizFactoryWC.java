package Aplicacao.WCQuiz;

import Framework.*;

public class QuizFactoryWC implements QuizFactory {
    public QuizTemplate criarQuiz(){
        return new WorldCupQuiz(new WorldCupQuestions().generateQuestions());
    }
}
