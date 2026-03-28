/*
Унагаев Егор Б763-2а 9 вариант
9. Определить, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
*/
package by.epam.learn.main;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String text = "На дворе трава, на траве дрова – раз дрова, два дрова, три дрова. Не руби дрова на траве двора.";
        text = text.toLowerCase(Locale.ROOT);
        text = text.replaceAll("[^\\p{L}\\p{N}]+", " ");
        String[] words = text.trim().isEmpty() ? new String[0] : text.trim().split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        List<String> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);
        for (String w : keys) {
            System.out.println(w + " - " + freq.get(w));
        }
    }
}
