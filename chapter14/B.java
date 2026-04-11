/*
Унагаев Егор Б763-2а
Вариант 9
3. Написать программу, сканирующую сеть в указанном диапазоне
IP-­адресов на наличие активных компьютеров.
*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String baseIP = "192.168.0.0"; // Базовая подсеть (измените под вашу)
        int startIP = 1;
        int endIP = 254;
        int timeout = 1000; // Тайм-аут в миллисекундах
        int threads = 30;   // Количество одновременных потоков

        System.out.println("Сканируем подсеть: " + baseIP + "0/24...");

        // Создаем пул потоков для параллельной проверки
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int i = startIP; i <= endIP; i++) {
            final String host = baseIP + i;
            executor.submit(() -> checkAddress(host, timeout));
        }

        executor.shutdown();
        try {
            // Ждем завершения сканирования (10 минут)
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Сканирование завершенно.");
    }

    private static void checkAddress(String host, int timeout) {
        try {
            if (isPingable(host, timeout)) {
                System.out.println("[+] Узел доступен: " + host);
            }
        } catch (Exception e) {
            // Игнорируем ошибки при сканировании
        }
    }

    private static boolean isPingable(String host, int timeout) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String command;

            if (os.contains("win")) {
                // Windows
                command = "ping -n 1 -w " + timeout + " " + host;
            } else {
                // Linux/Mac
                command = "ping -c 1 -W " + (timeout / 1000) + " " + host;
            }

            Process process = Runtime.getRuntime().exec(command);
            // Ждем завершения процесса. Если 0 - хост ответил.
            return process.waitFor() == 0;
        } catch (Exception e) {
            return false;
        }
    }
}
