package Aplicacao;

import Framework.*;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    Questions qs = new Questions();
    List<Question> questions = qs.generateQuestions();

    public void gameplay(){
        UI_App ui = new UI_App();
        Score score = new Score();
        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao quiz de conhecimentos gerais! Vamos testar suas habilidades!");
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
            score.calculateScore(answer, correctLetter);
            numQuestion++;
        }
        score.showScore();
    }

    public List<Question> get_questions_list(){
        return questions;
    }
}
