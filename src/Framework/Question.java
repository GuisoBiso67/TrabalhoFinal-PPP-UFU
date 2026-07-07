package Framework;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private List<Item> items;

    public Question(String question) {
        this.question = question;
        this.items = new ArrayList<>();
    }

    public String getStatement() {
        return question;
    }

    public void addItem(Item i) {
        this.items.add(i);
    }

    public List<Item> getItems() {
        return items;
    }
}
