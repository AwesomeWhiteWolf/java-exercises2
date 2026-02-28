/*
9 Унагаев Егор Б763-2а
Вариант B
9. Ввести с консоли n целых чисел. На консоль вывести: «Счастливые» числа (числа, которые при замене на сумму квадратов их цифр, повторяемой итеративно, в итоге приводят к единице)
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int sumSquaresOfDigits(int x) {
        int s = 0;
        x = Math.abs(x);
        while (x > 0) {
            int d = x % 10;
            s += d * d;
            x /= 10;
        }
        return s;
    }

    private static boolean isHappyNum(int n) {
        int x = Math.abs(n);
        int steps = 0;
        while (x != 1 && steps < 100) { // 100 шагов достаточно для нахождения счастливого числа
            x = sumSquaresOfDigits(x);
            steps++;
        }
        return x == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("Счастливые числа");
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n && scanner.hasNextInt(); i++) {
            nums.add(scanner.nextInt());
        }

        List<Integer> happyNum = new ArrayList<>();
        for (int num : nums) {
            if (isHappyNum(num)) {
                happyNum.add(num);
            }
        }

        System.out.println("Счастливые числа:");
        for (int happyN : happyNum) {
            System.out.println(hn);
        }
        scanner.close();
    }
}
