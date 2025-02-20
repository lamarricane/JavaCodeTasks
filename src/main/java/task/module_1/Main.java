package task.module_1;

public class Main {
    public static void main(String[] args) {

        /*Изучите внутреннюю реализацию класса StringBuilder и напишите свою
         с добавлением дополнительного метода - undo().
         Прежде чем приступать - прочитайте про паттерн snapshot и примените его в своей реализации.
         */
        StringBuilderMemento originator = new StringBuilderMemento();

        originator.append("String ");
        System.out.println(originator);

        originator.append("Builder ");
        System.out.println(originator);

        originator.append("Memento");
        System.out.println(originator);

        originator.undo();
        System.out.println(originator);

        originator.undo();
        System.out.println(originator);

        originator.replace(0, 6, "Char");
        System.out.println(originator);

        originator.undo();
        System.out.println(originator);
    }
}