package Aplicacao;

import Framework.*;

import java.util.ArrayList;
import java.util.List;

public class Questions implements FactoryQuestion {
    List<Question> questions = new ArrayList<>();
    @Override
    public List<Question> createQuestions() {
        Question q1 = new Question("Qual a capital do Brasil?");
        q1.addItem(new Item("Manaus", false));
        q1.addItem(new Item("Rio de Janeiro", false));
        q1.addItem(new Item("Brasilia", true));
        q1.addItem(new Item("Porto Alegre", false));
        questions.add(q1);

        return questions;
    }

    public void printQuestions() {
        int numQuestion = 1;
        for (Question q : questions) {
            System.out.println(numQuestion + ") " + q.getStatement());

            char letterItem = 'a';
            for(Item item : q.getItems()) {
                System.out.println(letterItem + ") " + item.getText());
                letterItem++;
            }

            numQuestion++;
        }
    }
}
