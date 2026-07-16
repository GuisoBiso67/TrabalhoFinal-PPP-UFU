package Aplicacao.Coding;

import Framework.Item;
import Framework.Question;
import Framework.QuizTemplate;
import Framework.ScoreStrategy;

import java.util.List;
import java.util.Scanner;

public class CodingQuiz extends QuizTemplate{
    CodingQuestions qs = new CodingQuestions();
    List<Question> questions = qs.generateQuestions();
    ScoreStrategy score = new Score();


    public CodingQuiz(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public void menu() {
        System.out.println("==========================================");
        System.out.println("Bem vindo ao quiz de Programacao!");
        System.out.println("Vamos testar suas habilidades...");
        System.out.println("==========================================");
    }

    @Override
    public void gameplay(){
        Scanner input = new Scanner(System.in);
        int numQuestion = 1;
        for (Question q : questions) {
            System.out.println(numQuestion + ") " + q.getStatement());
            char letterItem = 'a';
            char correctLetter = ' ';
            for(Item item : q.getItems()) {
                System.out.println(letterItem + ") " + item.getText());
                if(item.getCorrect()){
                    correctLetter = letterItem;
                }
                letterItem++;
            }
            System.out.println("Qual a sua resposta?");
            char answer = input.next().charAt(0);
            score.calculateScore(answer, correctLetter, 0);
            numQuestion++;
        }
    }

    @Override
    public void ending_score() {
        score.showScore();
    }

    public List<Question> get_questions_list(){
        return questions;
    }

    public void setScoreStrategy(ScoreStrategy scoreStrategy){
        score = scoreStrategy;
    }
}
