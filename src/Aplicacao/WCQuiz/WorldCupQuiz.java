package Aplicacao.WCQuiz;

import Aplicacao.Score.SimpleScore;
import Framework.*;

import java.util.List;
import java.util.Scanner;

public class WorldCupQuiz extends QuizTemplate{
    List<Question> questions;
    ScoreStrategy score = new SimpleScore();

    public WorldCupQuiz(List<Question> questions){
        this.questions = questions;
    }

    @Override
    public void menu() {
        System.out.println("==========================================");
        System.out.println("Bem vindo ao quiz sobre Copa do Mundo");
        System.out.println("Vamos testar seus conhecimentos futebolisticos...");
        System.out.println("==========================================");
    }

    @Override
    public void gameplay(){
        //UI_App ui = new UI_App(questions, score);
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
            if(answer == correctLetter){
                System.out.println("Resposta correta!");
            }else{
                System.out.println("Resposta incorreta! Alternativa certa: " + correctLetter);
            }
            score.calculateScore(answer, correctLetter, 0);
            numQuestion++;
        }
    }

    @Override
    public void ending_score() {
        score.showScore();
    }

    @Override
    public List<Question> get_questions_list(){
        return questions;
    }

    @Override
    public void setScoreStrategy(ScoreStrategy scoreStrategy){
        score = scoreStrategy;
    }
}
