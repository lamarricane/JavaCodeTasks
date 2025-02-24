package task.module_4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamCollectMapAdvancedExample {
    public static void main(String[] args) {
        /* 1. Создайте коллекцию студентов, где каждый студент содержит информацию о предметах,
           которые он изучает, и его оценках по этим предметам.
           2. Используйте Parallel Stream для обработки данных и создания Map, где ключ - предмет,
           а значение - средняя оценка по всем студентам.
           3. Выведите результат: общую Map с средними оценками по всем предметам.
         */
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        Map<String, Double> averageGradesBySubject = students.parallelStream()
                .flatMap(student -> student.getGrades().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)
                ));

        System.out.println("Average ratings in subjects:");
        averageGradesBySubject.forEach((subject, averageGrade) ->
                System.out.println(subject + ": " + averageGrade));
    }
}
