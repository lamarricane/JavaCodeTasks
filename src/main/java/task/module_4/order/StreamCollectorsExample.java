package task.module_4.order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        /* 1. Создайте список заказов с разными продуктами и их стоимостями.
           2. Группируйте заказы по продуктам.
           3. Для каждого продукта найдите общую стоимость всех заказов.
           4. Отсортируйте продукты по убыванию общей стоимости.
           5. Выберите три самых дорогих продукта.
           6. Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
         */
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        Map<String, List<Order>> groupedOrders = orders.stream().collect(Collectors.groupingBy(Order::getProduct));

        System.out.println("---Группировка по продуктам---");

        groupedOrders.forEach((product, orderList) -> {
            System.out.println("Product: " + product);
            orderList.forEach(order -> System.out.println("  Cost: " + order.getCost()));
        });

        System.out.println("---Сортировка продуктов по общей стоимости---");

        Map<String, Double> totalCostByProduct = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getCost)));

        List<Map.Entry<String, Double>> sortedProducts = totalCostByProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .toList();

        sortedProducts.forEach(entry ->
                System.out.println("Product: " + entry.getKey() + ", Total Cost: " + entry.getValue()));

        System.out.println("---Топ 3 самых дорогих продукта---");

        List<Order> top3ExpensiveOrders = orders.stream()
                .sorted((o1, o2) -> Double.compare(o2.getCost(), o1.getCost()))
                .limit(3)
                .toList();

        top3ExpensiveOrders.forEach(order ->
                System.out.println("Product: " + order.getProduct() + ", Cost: " + order.getCost()));

        double totalCost = top3ExpensiveOrders.stream()
                .mapToDouble(Order::getCost)
                .sum();

        System.out.println("Total cost of top 3 orders: " + totalCost);
    }
}