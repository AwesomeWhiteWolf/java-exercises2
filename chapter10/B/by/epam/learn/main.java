/*

Выполнить задания из варианта B гл. 4, сохраняя объекты приложения в одном или нескольких файлах с применением механизма сериализации. Объекты
могут содержать поля, помеченные как static, а также transient. Для изменения
информации и извлечения информации в файле создать специальный классконнектор с необходимыми для выполнения этих задач методами.

вот задание из 4 главы:
9. Авиакомпания. Определить иерархию самолетов. Создать авиакомпанию.
Посчитать общую вместимость и грузоподъемность. Провести сортировку
самолетов компании по дальности полета. Найти самолет в компании, соответствующий заданному диапазону параметров потребления горючего.
*/
package by.epam.learn.main;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Airline myAirline = new Airline();
        myAirline.addPlane(new PassengerPlane("Boeing 737", 5700, 189, 20.5, 2500));
        myAirline.addPlane(new CargoPlane("An-124", 4800, 20, 120.0, 12000));
        myAirline.addPlane(new PassengerPlane("Airbus A320", 6100, 150, 16.0, 2200));

        String fileName = "airline.dat";

        try {
            FileConnector.saveAirline(myAirline, fileName);
            Airline loadedAirline = FileConnector.loadAirline(fileName);
            System.out.println("Общая вместимость: " + loadedAirline.getTotalCapacity());
            loadedAirline.sortByRange();
            System.out.println("Сортировка по дальности: " + loadedAirline.getFleet());
            System.out.println("Расход 2000-3000: " + loadedAirline.findByFuel(2000, 3000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
