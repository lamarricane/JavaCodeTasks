package task.module_2;

import java.util.Arrays;

import static task.module_2.ArrayFilter.filter;

public class Main {
    public static void main(String[] args) {

    /*Напишите метод, который получает на вход массив элементов
    и возвращает Map ключи в котором - элементы, а значения - сколько раз встретился этот элемент
    */
        final String[] arrayString = {"juice", "tea", "coffee", "tea", "tequila", "margarita", "tequila", "tea", "milk", "coffee"};
        ItemCountMap map = new ItemCountMap();
        System.out.println(map.createItemCountMap(arrayString));
        System.out.println("");

    /*Напишите метод filter, который принимает на вход массив любого типа,
    вторым аргументом метод должен принимать класс, реализующий интерфейс Filter,
    в котором один метод - Object apply(Object o).
    метод должен быть реализован так чтобы возвращать новый массив,
    к каждому элементу которого была применена функция apply
    */
        Object[] array = {1, 2, null, 3, null, 4};
        Object[] strings = {"juice", null, "tea", "milk", null};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(strings));

        Filter nullFilter = o -> o;
        System.out.println("После фильтрации");

        Object[] filteredArray = filter(array, nullFilter);
        Object[] filteredStrings = filter(strings, nullFilter);
        System.out.println(Arrays.toString(filteredArray));
        System.out.println(Arrays.toString(filteredStrings));
    }
}
