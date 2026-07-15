package Aplicacao;

import Framework.*;

import java.util.*;

public class WorldCupQuestions implements QuestionsGenerator {
    private List<Question> questions = new ArrayList<>();
    @Override
    public List<Question> generateQuestions() {
        Question q1 = new Question("Qual o primeiro país a ganhar a Copa?", new ArrayList<>(Arrays.asList(
                new Item("Brasil", false),
                new Item("Inglaterra", false),
                new Item("Uruguai", true),
                new Item("Itália", false)
        )));
        questions.add(q1);

        Question q2 = new Question("Qual continente é o detentor de mais titulos de Copa do Mundo?", new ArrayList<>(Arrays.asList(
                new Item("Ásia", false),
                new Item("África", false),
                new Item("Europa", true),
                new Item("América do Sul", false)
        )));
        questions.add(q2);

        Question q3 = new Question("Qual país foi o detentor definitivo da taça Jules Rimet?", new ArrayList<>(Arrays.asList(
                new Item("Brasil", true),
                new Item("Uruguai", false),
                new Item("Itália", false),
                new Item("Argentina", false)
        )));
        questions.add(q3);

        Question q4 = new Question("Qual é o jogador mais jovem a marcar um gol em Copa do Mundo?", new ArrayList<>(Arrays.asList(
                new Item("Messi", false),
                new Item("Mbappe", false),
                new Item("Pele", true),
                new Item("Gavi", false)
        )));
        questions.add(q4);

        Question q5 = new Question("Em qual ano ocorreu a primeira Copa do Mundo realizada em um país africano?", new ArrayList<>(Arrays.asList(
                new Item("1990", false),
                new Item("2010", true),
                new Item("1978", false),
                new Item("2002", false)
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
