/*
9 Унагаев Егор Б763-2а
Вариант A 
9. Найти корни квадратного уравнения. Параметры уравнения передавать
с командной строкой.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите a b c через пробел: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("a - не число");
            scanner.close();
            return;
        }
        double a = scanner.nextDouble();

        if (!scanner.hasNextDouble()) {
            System.out.println("b - не число");
            scanner.close();
            return;
        }
        double b = scanner.nextDouble();

        if (!scanner.hasNextDouble()) {
            System.out.println("c - не число");
            scanner.close();
            return;
        }
        double c = scanner.nextDouble();

        // Если а = 0, уравнение линейное
        if (a == 0.0) {
            if (b == 0.0) {
                if (c == 0.0) {
                    System.out.println("Решение может быть любым"); // любой x будет удовлетворять равенству
                }
                else {
                    System.out.println("Нет решений");
                }
            } else {
                double x = -c / b;
                System.out.println("Один корень: " + x);
            }
            scanner.close();
            return;
        }

        double D = b * b - 4 * a * c;
        if (D > 0) {
            double sqrtD = Math.sqrt(D);
            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);
            System.out.println("Два корня: " + x1 + " и " + x2);
        } else if (D == 0) {
            double x = -b / (2 * a);
            System.out.println("Один корень: " + x);
        } else {
            System.out.println("Нет решений");
        }
        scanner.close();
    }
}
