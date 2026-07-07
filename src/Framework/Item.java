package Framework;

public class Item {
    private String text;
    private boolean correct;

    public Item(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public boolean getCorrect() {
        return correct;
    }
}
