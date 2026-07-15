package Aplicacao;

import Framework.*;

import java.util.*;

public class GeneralKnowledgeQuestions implements QuestionsGenerator {
    List<Question> questions = new ArrayList<>();
    @Override
    public List<Question> generateQuestions() {
        Question q1 = new Question("Qual a capital do Brasil?", new ArrayList<>(Arrays.asList(
                new Item("Manaus", false),
                new Item("Rio de Janeiro", false),
                new Item("Brasilia", true),
                new Item("Porto Alegre", false)
        )));
        questions.add(q1);

        Question q2 = new Question("Em qual continente fica o Egito?", new ArrayList<>(Arrays.asList(
                new Item("Ásia", false),
                new Item("África", true),
                new Item("Europa", false),
                new Item("América do Sul", false)
        )));
        questions.add(q2);

        Question q3 = new Question("Qual é o planeta mais próximo do Sol?", new ArrayList<>(Arrays.asList(
                new Item("Vênus", false),
                new Item("Marte", false),
                new Item("Mercúrio", true),
                new Item("Júpiter", false)
        )));
        questions.add(q3);

        Question q4 = new Question("Qual criatura do Minecraft explode ao se aproximar do jogador?", new ArrayList<>(Arrays.asList(
                new Item("Zombie", false),
                new Item("Enderman", false),
                new Item("Skeleton", false),
                new Item("Creeper", true)
        )));
        questions.add(q4);

        Question q5 = new Question("Qual é o maior mamífero do mundo?", new ArrayList<>(Arrays.asList(
                new Item("Elefante Africano", false),
                new Item("Baleia Azul", true),
                new Item("Tubarão Baleia", false),
                new Item("Girafa", false)
        )));
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
