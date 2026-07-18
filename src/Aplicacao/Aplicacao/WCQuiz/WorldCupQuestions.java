package Aplicacao.WCQuiz;

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

        Question q6 = new Question("Quem era o camisa 11 do Brasil na copa de 1970?", new ArrayList<>(Arrays.asList(
                new Item("Jairzinho", false),
                new Item("Tostao", false),
                new Item("Rivelino", true),
                new Item("Gerson", false)
        )));
        questions.add(q6);

        Question q7 = new Question("Quem sediou a Copa de 1998?", new ArrayList<>(Arrays.asList(
                new Item("Mexico", false),
                new Item("Espanha", false),
                new Item("Franca", true),
                new Item("Uruguai", false)
        )));
        questions.add(q7);

        Question q8 = new Question("Em qual ano ocorreu a primeira Copa do Mundo?", new ArrayList<>(Arrays.asList(
                new Item("1926", false),
                new Item("1930", true),
                new Item("1934", false),
                new Item("1938", false)
        )));
        questions.add(q8);

        Question q9 = new Question("Qual jogador eh o maior campeao da historia das copas?", new ArrayList<>(Arrays.asList(
                new Item("Maradona", false),
                new Item("Pele", true),
                new Item("Klose", false),
                new Item("Ronaldo Fenomeno", false)
        )));
        questions.add(q9);

        Question q10 = new Question("Qual jogador marcou mais gols em uma mesma partida de Copa?", new ArrayList<>(Arrays.asList(
                new Item("Pele", false),
                new Item("Salenko", true),
                new Item("Klose", false),
                new Item("Messi", false)
        )));
        questions.add(q10);

        Question q11 = new Question("Que pais sediou a primeira Copa do Mundo?", new ArrayList<>(Arrays.asList(
                new Item("Franca", false),
                new Item("Inglaterra", false),
                new Item("Uruguai", true),
                new Item("Mexico", false)
        )));
        questions.add(q11);

        Question q12 = new Question("Em que edicao foi introduzido o sistema de cartoes?", new ArrayList<>(Arrays.asList(
                new Item("Mexico 1970", true),
                new Item("Inglaterra 1966", false),
                new Item("Alemanha 1974", false),
                new Item("Chile 1962", false)
        )));
        questions.add(q12);

        Question q13 = new Question("Qual selecao jogou sob ameacas de morte feitas pelo governo de seu pais?", new ArrayList<>(Arrays.asList(
                new Item("Gana", false),
                new Item("Zaire", true),
                new Item("Costa do Marfim", false),
                new Item("Liberia", false)
        )));
        questions.add(q13);

        Question q14 = new Question("Qual seleçao africana se tornou a primeira do continente a chegar a uma semifinal de Copa do Mundo?", new ArrayList<>(Arrays.asList(
                new Item("Camaroes", false),
                new Item("Senegal", false),
                new Item("Marrocos", true),
                new Item("Gana", false)
        )));
        questions.add(q14);

        Question q15 = new Question("Qual a unica selecao que disputou todas as copas?", new ArrayList<>(Arrays.asList(
                new Item("Inglaterra", false),
                new Item("Argentina", false),
                new Item("Uruguai", false),
                new Item("Brasil", true)
        )));
        questions.add(q15);

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
