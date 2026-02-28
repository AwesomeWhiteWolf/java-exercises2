/* Унагаев Егор 9 вариант
Создать консольное приложение, удовлетворяющее следующим требованиям:
• Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
• Каждый класс должен иметь отражающее смысл название и информативный состав.
• Наследование должно применяться только тогда, когда это имеет смысл.
• При кодировании должны быть использованы соглашения об оформлении
кода java code convention.
• Классы должны быть грамотно разложены по пакетам.
• Консольное меню должно быть минимальным.
• Для хранения параметров инициализации можно использовать файлы.
9. Авиакомпания. Определить иерархию самолетов. Создать авиакомпанию.
Посчитать общую вместимость и грузоподъемность. Провести сортировку
самолетов компании по дальности полета. Найти самолет в компании, соответствующий заданному диапазону параметров потребления горючего.
*/
package by.epam.airline.main;

import entity.*;
import logic.AirlineService;
import java.util.Scanner;

public class AirlineMain {
    public static void main(String[] args) {
        Airline airline = new Airline();
        // Инициализация (можно заменить на чтение из файла)
        airline.addPlane(new PassengerPlane("Boeing 737", 5765, 160, 20000, 2500, 3));
        airline.addPlane(new CargoPlane("An-124", 4800, 20, 120000, 12000, 1000));
        airline.addPlane(new PassengerPlane("Airbus A320", 6150, 180, 18000, 2200, 4));

        AirlineService service = new AirlineService();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Система управления авиакомпанией ---");
        System.out.println("1. Рассчитать общую вместимость и грузоподъемность");
        System.out.println("2. Сортировать самолеты по дальности полета");
        System.out.println("3. Найти самолеты по потреблению топлива (2000-3000 л/100км)");
        System.out.print("Выберите пункт: ");

        int choice = scanner.hasNextInt() ? scanner.nextInt() : 0;

        switch (choice) { // Использование оператора выбора
            case 1 -> {
                System.out.println("Общая вместимость: " + service.calculateTotalCapacity(airline));
                System.out.println("Общая грузоподъемность: " + service.calculateTotalPayload(airline));
            }
            case 2 -> service.sortByFlightRange(airline).forEach(System.out::println);
            case 3 -> service.findByFuelRange(airline, 2000, 3000).forEach(System.out::println);
            default -> System.out.println("Некорректный ввод.");
        }
        scanner.close();
    }
}
