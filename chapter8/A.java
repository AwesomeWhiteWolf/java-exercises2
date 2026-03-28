/*
Унагаев Егор Б763-2а 9 вариант
9. Определить, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
*/
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        // Пример текста. В реальном задании можно заменить на ввод с консоли/файла.
        String text = "Мама мыла раму. Мама мыла раму, а папа чинил стул!";

        // Приводим к нижнему регистру
        text = text.toLowerCase(Locale.ROOT);

        // Заменяем всё, что НЕ буква и НЕ цифра, на пробел
        text = text.replaceAll("[^\\p{L}\\p{N}]+", " ");

        String[] words = text.trim().isEmpty() ? new String[0] : text.trim().split("\\s+");

        Map<String, Integer> freq = new HashMap<>();

        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Вывод результата
        // (можно отсортировать по ключу или по частоте — по желанию)
        List<String> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        for (String w : keys) {
            System.out.println(w + " - " + freq.get(w));
        }
    }
}не
