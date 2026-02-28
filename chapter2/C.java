/*
9 Унагаев Егор Б763-2а
Вариант C
9. Ввести с консоли n-размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью генератора случайных
чисел. Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое
*/

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.hasNextInt() ? scanner.nextInt() : 0;
        if (n <= 0) return;

        int[][] a = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = r.nextInt(2 * n + 1) - n;

        // матрица A
        for (int[] row : a) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }

        double[][] b = new double[n][n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) sum += a[i][j];
            double mean = (double) sum / n;
            for (int j = 0; j < n; j++) b[i][j] = a[i][j] - mean;
        }

        System.out.println("Результат: матрица B");
        for (double[] row : b) {
            for (double v : row) System.out.printf("%.4f ", v);
            System.out.println();
        }
        scanner.close();
    }
}
