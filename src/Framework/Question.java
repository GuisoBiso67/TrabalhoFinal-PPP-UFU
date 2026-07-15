package Framework;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private List<Item> items;

    public Question(String question, List<Item> items) {
        this.question = question;
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }

    public String getStatement() {
        return question;
    }

    public List<Item> getItems() {
        return items;
    }
}
