//Унагаев Егор Б763-2а
// 1. Создать файл XML и соответствующую ему схему XSD.2. При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения.//3. Сгенерировать класс, соответствующий данному описанию.//4. Создать приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла. Для разбора использовать//SAX, DOM и StAX-парсеры. Для сортировки объектов использовать интерфейс Comparator.//5. Произвести проверку XML-документа с привлечением XSD.//6. Определить метод, производящий преобразование разработанного XMLдокумента в документ, указанный в каждом задании.
//9. Конфеты.
//— Name — название конфеты;
//— Energy — калорийность (ккал);
//— Type (должно быть несколько) — тип конфеты (карамель, ирис, шоколадная [с начинкой либо нет]);
//— Ingredients (должно быть несколько) — ингредиенты: вода, сахар (в мг),
//фруктоза (в мг), тип шоколада (для шоколадных), ванилин (в мг);
//— Value — пищевая ценность: белки (в г), жиры (в г) и углеводы (в г);
//— Production — предприятие-изготовитель.
//Корневой элемент назвать Candy.
//С помощью XSL преобразовать XML-файл в формат HTML, при выводе
//отсортировать по месту изготовления


import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@XmlRootElement(name = "Candy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candy {

    @XmlElement(name = "CandyType")
    private List<CandyType> candies;

    public Candy() {
        candies = new ArrayList<>();
    }

    public List<CandyType> getCandies() {
        return candies;
    }

    public void setCandies(List<CandyType> candies) {
        this.candies = candies;
    }

    @Override
    public String toString() {
        return "Candy [" + "candies - " + candies + "]";
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class CandyType {

        @XmlElement(name = "Name")
        private String name;

        @XmlElement(name = "Energy")
        private int energy;

        @XmlElement(name = "Type")
        private String type;

        @XmlElement(name = "Ingredients")
        private Ingredients ingredients;

        @XmlElement(name = "Value")
        private Value value;

        @XmlElement(name = "Production")
        private String production;

        public CandyType() {
        }

        public CandyType(String name, int energy, String type, Ingredients ingredients, Value value, String production) {
            this.name = name;
            this.energy = energy;
            this.type = type;
            this.ingredients = ingredients;
            this.value = value;
            this.production = production;
        }

        @Override
        public String toString() {
            return "CandyType [" + "name - '" + name  + ", energy - " + energy + ", type - '" + type  +
                    ", ingredients - " + ingredients + ", value - " + value + ", production - " + production  + "]";
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Ingredients {

        @XmlElement(name = "Water")
        private int water;

        @XmlElement(name = "Sugar")
        private int sugar;

        @XmlElement(name = "Fructose")
        private int fructose;

        @XmlElement(name = "ChocolateType")
        private String chocolateType;

        @XmlElement(name = "Vanillin")
        private int vanillin;

        public Ingredients() {
        }

        @Override
        public String toString() {
            return "Ingredients [" + "water - " + water + ", sugar - " + sugar + ", fructose - " +
                    fructose + ", chocolateType ='" + chocolateType + '\'' + ", vanillin - " + vanillin + "]";
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Value {

        @XmlElement(name = "Proteins")
        private double proteins;

        @XmlElement(name = "Fats")
        private double fats;

        @XmlElement(name = "Carbohydrates")
        private double carbohydrates;

        public Value() {
        }

        @Override
        public String toString() {
            return "Значение [" + "proteins - " + proteins + ", fats - " + fats + ", carbohydrates -" + carbohydrates + "]";
        }
    }
}
