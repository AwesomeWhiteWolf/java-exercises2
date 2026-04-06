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
