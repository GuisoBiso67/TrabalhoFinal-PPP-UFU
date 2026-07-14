package Framework;

import Aplicacao.Score;

import java.util.List;

public abstract class QuizTemplate {
    //private List<Question> questionsList;

    abstract public void menu();
    abstract public void gameplay();
    abstract public void ending_score();

    public void quiz(){
        menu();
        gameplay();
        ending_score();
        end_program();
    }

    public void end_program(){
        System.exit(0);
    }
}
