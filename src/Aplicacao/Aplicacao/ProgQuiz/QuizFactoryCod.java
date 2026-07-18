package Aplicacao.ProgQuiz;

import Aplicacao.WCQuiz.*;
import Framework.QuizFactory;
import Framework.QuizTemplate;

public class QuizFactoryCod implements QuizFactory {
    public QuizTemplate criarQuiz(){
        return new CodingQuiz (new CodingQuestions().generateQuestions());
    }
}
