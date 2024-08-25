public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");
        dogBobik.run(150);
        catMurzik.run(150);
        catMurzik.swim(10);
        Bowl bowl = new Bowl(25);
        Cat[] cats = {catMurzik, catBarsik};
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }
        bowl.addFood(10);
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Белый");
        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }
    public static void printShapeInfo(Shape shape) {
        System.out.println("Фигура: " + shape.getName());
        System.out.println("Периметр: " + shape.calculatePerimeter());
        System.out.println("Площадь: " + shape.calculateArea());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
        System.out.println();
    }
}