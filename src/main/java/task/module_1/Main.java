package task.module_1;

public class Main {
    public static void main(String[] args) {
        StringBuilderOriginator originator = new StringBuilderOriginator();
        StringBuilderCaretaker caretaker = new StringBuilderCaretaker();

        originator.append("String ");
        caretaker.saveState(originator);
        System.out.println(originator);

        originator.append("Builder ");
        caretaker.saveState(originator);
        System.out.println(originator);

        originator.append("Memento");
        System.out.println(originator);

        caretaker.undo(originator);
        System.out.println(originator);
        caretaker.undo(originator);
        caretaker.saveState(originator);
        System.out.println(originator);

        originator.replace(0, 6, "Char");
        System.out.println(originator);
        caretaker.undo(originator);
        System.out.println(originator);
    }
}