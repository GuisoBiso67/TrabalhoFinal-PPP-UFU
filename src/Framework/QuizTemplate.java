package Framework;

import java.util.List;

public abstract class QuizTemplate {
    //private List<Question> questionsList;

    abstract public void menu();
    abstract public void gameplay();
    abstract public void ending_score();
    abstract public void setScoreStrategy(ScoreStrategy scoreStrategy);
    abstract public List<Question> get_questions_list();

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
