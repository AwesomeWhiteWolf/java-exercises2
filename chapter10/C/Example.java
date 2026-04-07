/*
Унагаев Егор 9 Вариант
9. Вывести коллекцию количества вхождений символа в тексте соответственно из файла.
*/

package by.epam.learn.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharCounterMain {
    public static void main(String[] args) {
        // Путь к файлу (директория data должна существовать в корне проекта) [3, 4]
        Path path = Paths.get("data", "text.txt");

        try (Stream<String> lines = Files.lines(path)) { // Чтение строк из файла
            
            // Обработка данных через Stream API
            Map<Character, Long> charCounts = lines
                // Преобразуем каждую строку в поток её символов
                .flatMapToInt(String::chars)
                // Преобразуем коды символов (int) в объекты Character
                .mapToObj(c -> (char) c)
                // Группируем по символу и считаем количество вхождений
                .collect(Collectors.groupingBy(
                    Function.identity(), 
                    Collectors.counting()
                ));

            // Вывод полученной коллекции
            System.out.println("Количество вхождений символов:");
            charCounts.forEach((character, count) -> 
                System.out.printf("'%s' : %d%n", character, count));

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
