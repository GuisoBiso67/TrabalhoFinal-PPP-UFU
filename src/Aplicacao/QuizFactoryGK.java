package Aplicacao;

import Framework.*;

public class QuizFactoryGK implements QuizFactory {

    public QuizTemplate criarQuiz(){
        return new GeneralKnowledgeQuiz(new GeneralKnowledgeQuestions().generateQuestions());
    }
}
