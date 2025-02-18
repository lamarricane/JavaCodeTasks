package task.module_1;

public class StringBuilderOriginator {
    private StringBuilder stringBuilder;

    public StringBuilderOriginator() {
        this.stringBuilder = new StringBuilder();
    }

    public void append(String str) {
        stringBuilder.append(str);
    }

    public void replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
    }

    static class Memento {
        private final String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    public Memento createMemento() {
        return new Memento(stringBuilder.toString());
    }

    public void restore(Memento memento) {
        this.stringBuilder = new StringBuilder(memento.getState());
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}



