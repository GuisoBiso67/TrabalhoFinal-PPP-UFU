package Aplicacao;

import Framework.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Questions quiz = new Questions();
        quiz.createQuestions();
        quiz.printQuestions();
    }
}
