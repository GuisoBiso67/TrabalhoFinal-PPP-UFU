package Aplicacao.ProgQuiz;

import Aplicacao.*;
import Framework.*;

import java.util.List;
import java.util.Scanner;

public class CodingQuiz extends QuizTemplate{
    List<Question> questions;
    ScoreStrategy score = new TimeBasedScore();

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
        UI_App ui = new UI_App(questions, score);
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
            System.out.println("------------------------------------------------------------");
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
