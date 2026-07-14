package Framework;

public abstract class QuizTemplate {
    //private List<Question> questionsList;

    abstract public void menu();
    abstract public void gameplay();
    abstract public void ending_score();
    abstract public void setScoreStrategy(ScoreStrategy scoreStrategy);

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
