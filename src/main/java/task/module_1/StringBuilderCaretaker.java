package task.module_1;

import java.util.Stack;

class StringBuilderCaretaker {
    private final Stack<StringBuilderOriginator.Memento> history = new Stack<>();

    public void saveState(StringBuilderOriginator originator) {
        history.push(originator.createMemento());
    }

    public void undo(StringBuilderOriginator originator) {
        if (!history.isEmpty()) {
            originator.restore(history.pop());
        }
    }
}