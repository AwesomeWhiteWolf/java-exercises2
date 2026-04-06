package by.epam.learn.FileConnector;
import java.io.*;
import java.util.*;

// Rласс для сохранения и загрузки объектов через сериализацию.
class FileConnector {
    public static void saveAirline(Airline airline, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(airline);
        }
    }

    public static Airline loadAirline(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Airline) ois.readObject();
        }
    }
}
