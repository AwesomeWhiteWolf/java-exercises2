/*
Унагаев Егор 9 Вариант
9. Создать класс BlueRayDisc с внутренним классом, с помощью объектов
которого можно хранить информацию о каталогах, подкаталогах и записях.
*/
package by.epam.learn.main;

import java.util.ArrayList;
import java.util.List;

public class BlueRayDisc {
    private String title;
    private Content rootDirectory;

    public BlueRayDisc(String title) {
        this.title = title;
        // Создаем корневой каталог при инициализации диска
        this.rootDirectory = new Content("ROOT", true);
    }

    public class Content {
        private String name;
        private boolean isDirectory;
        private List<Content> subItems; // Список для подкаталогов и записей

        public Content(String name, boolean isDirectory) {
            this.name = name;
            this.isDirectory = isDirectory;
            if (isDirectory) {
                this.subItems = new ArrayList<>(); // Коллекция для хранения
            }
        }

        // Метод для добавления подкаталога или записи
        public void add(Content item) {
            if (this.isDirectory) {
                this.subItems.add(item);
            } else {
                System.out.println("Ошибка: нельзя добавить элемент в запись (не каталог).");
            }
        }

        @Override
        public String toString() {
            String type = isDirectory ? "[Каталог]" : "[Запись]";
            return type + " " + name;
        }

        public void display(int level) {
            System.out.println("  ".repeat(level) + this);
            if (isDirectory && subItems != null) {
                for (Content item : subItems) {
                    item.display(level + 1);
                }
            }
        }
    }

    public void showDiscStructure() {
        System.out.println("Структура диска: " + title);
        rootDirectory.display(0);
    }

    public Content getRoot() {
        return rootDirectory;
    }

    public static void main(String[] args) {
        BlueRayDisc disc = new BlueRayDisc("Фильмы 2024");

        // Создание объектов
        BlueRayDisc.Content root = disc.getRoot();

        BlueRayDisc.Content dir1 = disc.new Content("Disney", true);
        BlueRayDisc.Content subDir1 = disc.new Content("Star Wars", true);
        BlueRayDisc.Content movie1 = disc.new Content("Episode III – Revenge of the Sith.mkv", false);

        BlueRayDisc.Content dir2 = disc.new Content("Music", true);
        BlueRayDisc.Content track1 = disc.new Content("Upside Down.mp3", false);
        BlueRayDisc.Content track2 = disc.new Content("Rise.mp3", false);

        // Формирование иерархии
        root.add(dir1);
        dir1.add(subDir1);
        subDir1.add(movie1);

        root.add(dir2);
        dir2.add(track1);
        dir2.add(track2);

        // Вывод структуры
        disc.showDiscStructure();
    }
}
