package task.module_4;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        /* 1. Реализуйте класс FactorialTask, который расширяет RecursiveTask.
           Этот класс будет выполнять рекурсивное вычисление факториала числа.
           2. В конструкторе FactorialTask передайте число n, факториал которого нужно вычислить.
           3. В методе compute() разбейте задачу на подзадачи и используйте fork() для их асинхронного выполнения.
           4. Используйте join() для получения результатов подзадач и комбинирования их для получения
           общего результата.
           5. В основном методе создайте экземпляр FactorialTask с числом,
           для которого нужно вычислить факториал, и запустите его в ForkJoinPool.
           6. Выведите результат вычисления факториала.
         */
        int n = 10; // Вычисление факториала для числа 10

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(n);

        long result = forkJoinPool.invoke(factorialTask);

        System.out.println("Факториал " + n + "! = " + result);
    }
}