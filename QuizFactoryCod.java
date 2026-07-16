package Aplicacao.Coding;

import Aplicacao.WorldCup.WorldCupQuestions;
import Aplicacao.WorldCup.WorldCupQuiz;
import Framework.QuizFactory;
import Framework.QuizTemplate;

public class QuizFactoryCod implements QuizFactory {
    public QuizTemplate criarQuiz(){
        return new CodingQuiz (new CodingQuestions().generateQuestions());
    }
}
