package task.module_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringBuilderMemento {
    private StringBuilder stringBuilder;
    private Deque<String> history;

    public StringBuilderMemento() {
        this.stringBuilder = new StringBuilder();
        this.history = new ArrayDeque<>();
    }

    public void append(String str) {
        saveState();
        stringBuilder.append(str);
    }

    public void replace(int start, int end, String str) {
        saveState();
        stringBuilder.replace(start, end, str);
    }

    private void saveState() {
        history.push(stringBuilder.toString());
    }

    public void undo() {
        if (!history.isEmpty()) {
            stringBuilder = new StringBuilder(history.pop());
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}



