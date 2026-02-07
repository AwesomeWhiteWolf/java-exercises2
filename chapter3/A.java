/*
Унагаев Егор Б763-2а 9 вариант
9. Product: id, Наименование, UPC, Производитель, Цена, Срок хранения,
Количество.
Создать массив объектов. Вывести:
a) список товаров для заданного наименования;
b) список товаров для заданного наименования, цена которых не превосходит заданную;
c) список товаров, срок хранения которых больше заданного
*/
import java.util.*;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    String upc;
    String manufacturer;
    double price;
    int shelfLifeDays; // срок хранения
    int quantity;

    Product(int id, String name, String upc, String manufacturer,
            double price, int shelfLifeDays, int quantity) {
        this.id = id; this.name = name; this.upc = upc; this.manufacturer = manufacturer;
        this.price = price; this.shelfLifeDays = shelfLifeDays; this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Продукт{id=%d, название=%s, цена=%.2f, срок хранения=%dd, количество=%d}",
                id, name, price, shelfLifeDays, quantity);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Молоко", "0001", "Простоквашино", 1.20, 10, 50),
                new Product(2, "Хлеб", "0002", "БХП", 0.80, 3, 100),
                new Product(3, "Сыр", "0003", "Простоквашино", 4.50, 30, 20),
                new Product(4, "Молоко", "0004", "Домик на ферме", 1.10, 7, 40),
                new Product(5, "Йогурт", "0005", "Простоквашино", 0.90, 14, 60)
        );

        String nameQuery = "Молоко";
        double maxPrice = 1.15;
        int minShelf = 7;

        System.out.println("a) Название продукта = " + nameQuery);
        products.stream()
                .filter(p -> p.name.equalsIgnoreCase(nameQuery))
                .forEach(System.out::println);

        System.out.println("\nb) Название продукта = " + nameQuery + " и с ценой <= " + maxPrice);
        products.stream()
                .filter(p -> p.name.equalsIgnoreCase(nameQuery) && p.price <= maxPrice)
                .forEach(System.out::println);

        System.out.println("\nc) Продукт со сроком хранения > " + minShelf + " дней");
        products.stream()
                .filter(p -> p.shelfLifeDays > minShelf)
                .forEach(System.out::println);
    }
}
