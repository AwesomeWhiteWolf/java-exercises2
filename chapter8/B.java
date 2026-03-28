/*
Унагаев Егор Б763-2а 9 вариант
9. Все слова текста рассортировать по возрастанию количества заданной буквы
в слове.Слова с одинаковымколичествомрасположить в алфавитномпорядке.
*/
package by.epam.learn.main;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "Около кола колокола, около ворот коловорот.";
        char letter = 'о';

        Map<String, Integer> freq = countWords(text);

        // получаем список уникальных слов и сортируем по возрастанию
        List<String> wordsSorted = freq.keySet().stream()
                .sorted((w1, w2) -> {
                    int c1 = countLetter(w1, letter);
                    int c2 = countLetter(w2, letter);

                    if (c1 != c2) {
                        return Integer.compare(c1, c2);
                    }
                    return w1.compareTo(w2); // отсортированный
                })
                .collect(Collectors.toList());

        for (String w : wordsSorted) {
            System.out.println(w + " -> " + freq.get(w) + " (буква '" + letter + "' = " + countLetter(w, letter) + ")");
        }
    }
    
    // необходимые методы
    private static Map<String, Integer> countWords(String text) {
        if (text == null || text.isBlank()) {
            return Collections.emptyMap();
        }

        String lower = text.toLowerCase(Locale.ROOT);

        String cleaned = lower.replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}]+", " ");

        String[] words = cleaned.trim().isEmpty()
                ? new String[0]
                : cleaned.trim().split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            if (!w.isBlank()) {
                freq.merge(w, 1, Integer::sum);
            }
        }
        return freq;
    }

    private static int countLetter(String word, char letter) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        char target = Character.toLowerCase(letter);

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == target) {
                count++;
            }
        }
        return count;
    }
}
