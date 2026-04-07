/*
Унагаев Егор Б763-2а 9 вариант
9. Аукцион. На торги выставляется несколько лотов. Участники аукциона делают заявки. Заявку можно корректировать в сторону увеличения несколько раз за торги одного лота. Аукцион определяет победителя и переходит
к следующему лоту. Участник, не заплативший за лот в заданный промежуток времени, отстраняется на несколько лотов от торгов.
*/
import java.util.*;

class Bidder {
    String name;
    int banCounter = 0; // счечик отстранения от лотов - блокировки

    public Bidder(String name) { this.name = name; }

    public boolean isBanned() { return banCounter > 0; }
    public void reduceBan() { if (banCounter > 0) banCounter--; }
}

class Lot {
    String title;
    double currentPrice = 0;
    Bidder winner = null;

    public Lot(String title, double startPrice) {
        this.title = title;
        this.currentPrice = startPrice;
    }
}

public class AuctionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Bidder> bidders = Arrays.asList(new Bidder("Иван"), new Bidder("Егор"), new Bidder("Олег"), new Bidder("Анна"));
        List<Lot> lots = Arrays.asList(new Lot("Учебник по java-разработке", 1000), new Lot("Римский шлем", 10), new Lot("Часы apple watch", 200));

        for (Lot lot : lots) {
            System.out.println("\n--- Торги за лот: " + lot.title + " (Старт: " + lot.currentPrice + ") ---");

            // Уменьшаем блокировку на один у всех перед началом нового лота
            bidders.forEach(Bidder::reduceBan);

            boolean bidding = true;
            while (bidding) {
                System.out.println("Введите имя участника и ставку (или 'stop' для завершения лота):");
                String input = scanner.next();
                if (input.equalsIgnoreCase("stop")) break;

                double bidAmount = scanner.nextDouble();
                Bidder currentBidder = findBidder(bidders, input);

                if (currentBidder == null) {
                    System.out.println("Участник не найден.");
                } else if (currentBidder.isBanned()) {
                    System.out.println(currentBidder.name + " ОТСТРАНЕН! Осталось лотов: " + currentBidder.banCounter);
                } else if (bidAmount > lot.currentPrice) {
                    lot.currentPrice = bidAmount;
                    lot.winner = currentBidder;
                    System.out.println("Новая цена: " + lot.currentPrice + " от " + lot.winner.name);
                } else {
                    System.out.println("Ставка должна быть выше текущей!");
                }
            }

            if (lot.winner != null) {
                System.out.println("Победитель: " + lot.winner.name + ". Оплачено вовремя? (да/нет)");
                String paid = scanner.next();
                if (paid.equalsIgnoreCase("нет")) {
                    System.out.println(lot.winner.name + " не оплатил! Блокировка на 2 лота.");
                    lot.winner.banCounter = 2;
                }
            } else {
                System.out.println("Лот не продан.");
            }
        }
        System.out.println("\nАукцион завершен.");
    }

    private static Bidder findBidder(List<Bidder> list, String name) {
        return list.stream().filter(b -> b.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
