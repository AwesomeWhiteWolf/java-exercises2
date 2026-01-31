/*
9 Унагаев Егор Б763-2а
Вариант B 
9. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца  от 1 до 12 ");
        if (!scanner.hasNextInt()) { // Проверка числа
            System.out.println("требуется ввести целое число от 1 до 12.");
            scanner.close();
            return;
        }

        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Число должно быть в диапазоне от 1 до 12.");
            scanner.close();
            return;
        }
        String[] months = {
                "январь", "февраль", "март", "апрель", "май", "июнь",
                "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"
        };

        System.out.println("Это месяц: " + months[monthNumber - 1]); //-1 так как индексация идёт с нуля
        scanner.close();
    }
}
