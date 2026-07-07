package Aplicacao;

import Framework.*;

import java.util.*;

public class Questions implements FactoryQuestion {
    List<Question> questions = new ArrayList<>();
    @Override
    public List<Question> generateQuestions() {
        Question q1 = new Question("Qual a capital do Brasil?");
        q1.addItem(new Item("Manaus", false));
        q1.addItem(new Item("Rio de Janeiro", false));
        q1.addItem(new Item("Brasilia", true));
        q1.addItem(new Item("Porto Alegre", false));
        questions.add(q1);

        Question q2 = new Question("Em qual continente fica o Egito?");
        q2.addItem(new Item("Ásia", false));
        q2.addItem(new Item("África", true));
        q2.addItem(new Item("Europa", false));
        q2.addItem(new Item("América do Sul", false));
        questions.add(q2);

        Question q3 = new Question("Qual é o planeta mais próximo do Sol?");
        q3.addItem(new Item("Vênus", false));
        q3.addItem(new Item("Marte", false));
        q3.addItem(new Item("Mercúrio", true));
        q3.addItem(new Item("Júpiter", false));
        questions.add(q3);

        Question q4 = new Question("Qual criatura do Minecraft explode ao se aproximar do jogador?");
        q4.addItem(new Item("Zombie", false));
        q4.addItem(new Item("Enderman", false));
        q4.addItem(new Item("Skeleton", false));
        q4.addItem(new Item("Creeper", true));
        questions.add(q4);

        Question q5 = new Question("Qual é o maior mamífero do mundo?");
        q5.addItem(new Item("Elefante Africano", false));
        q5.addItem(new Item("Baleia Azul", true));
        q5.addItem(new Item("Tubarão Baleia", false));
        q5.addItem(new Item("Girafa", false));
        questions.add(q5);

        return questions;
    }

    public void printAllQuestions() {
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
