/*
Унагаев Егор Б763-2а 9 вариант
9. Осуществить форматирование заданного текста с выравниванием по левому краю. Программа должна разбивать текст на строки с длиной, не превосходящей заданного количества символов. Если очередное слово не помещается в текущей строке, его необходимо переносить на следующую.
*/
package by.epam.learn.main;
public class Main {
    public static void main(String[] args) {
        String text = "Забыл Панкрат Кондратов домкрат, а Панкрату без домкрата не поднять на тракте трактор. И ждёт на тракте трактор домкрат.";
        int maxLength = 25;
        formatText(text, maxLength);
    }

    public static void formatText(String text, int limit) {
        String[] words = text.split("\\s+"); // Разбиваем по пробелам
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            // проверка: поместится ли слово в текущую строку (+1 на пробел)
            if (line.length() + word.length() <= limit) {
                if (line.length() > 0) line.append(" ");
                line.append(word);
            } else {
                System.out.println(line.toString());
                line = new StringBuilder(word);
            }
        }

        // печатаем то что осталось
        if (line.length() > 0) {
            System.out.println(line.toString());
        }
    }
}
