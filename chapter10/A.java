/*
Унагаев Егор Б763-2а 9 вариант
В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
• каждая строка состоит из одного слова;
• каждая строка состоит из нескольких слов.
Имена входного и выходного файлов, а также абсолютный путь к ним могут
быть введены как параметры командной строки или храниться в файле.

1. В каждой строке найти и удалить заданную подстроку.
*/
package by.epam.learn.main;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Использование: java SubstringRemover <вход> <выход> <подстрока>");
            return;
        }

        String inputPath = args[0];
        String outputPath = args[1];
        String target = args[2];

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // удаляем подстроку во всей строке
                String processedLine = line.replace(target, "");
                writer.write(processedLine);
                writer.newLine();
            }

            System.out.println("Обработка завершена успешно.");

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
