/*
Унагаев Егор Б763-2а 9 вариант
9. Из текста Java-программы удалить все виды комментариев.
*/
package by.epam.learn.main;
import java.io.*;
import java.nio.file.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentRemover {

    public static void main(String[] args) {
        String inputPath = "Example.java"; 
        String outputPath = "ExampleCleaned.java";

        try {
            String content = Files.readString(Path.of(inputPath));

            // Регулярные выражение для поиска всех видов комментариев
            // (//.*) - однострочные
            // (/\*[\s\S]*?\*/) - многострочные
            String regex = "(//.*)|(/\\*[\\s\\S]*?\\*/)";

            // Удаляем комментарии
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            String result = matcher.replaceAll("");

            Files.writeString(Path.of(outputPath), result);

            System.out.println("Комментарии успешно удалены. Результат в файле: " + outputPath);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}

