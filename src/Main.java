//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mail.box",
                "79115645654", 50000, 37 );
        employee[0].printConsole();
        employee[1] = new Employee("Ivanov Sergey", "Data Analyst", "sergien@mail.box",
                "79118764567", 180000, 27 );
        employee[1].printConsole();
        employee[2] = new Employee("Kurshev Ilya", "Data Engineer", "ilya.kurshev.88@mail.ru",
                "79117832312", 140000, 39 );
        employee[2].printConsole();
        employee[3] = new Employee("Fedorov Ivan", "UI designer", "ivan.fedorov.12@mail.ru",
                "79117776532", 90000, 26 );
        employee[3].printConsole();
        employee[4] = new Employee("Loshiev Petr", "Manager", "petr.loshiev.99@mail.ru",
                "79118123452", 200000, 38 );
        employee[4].printConsole();
        Park amusementPark = new Park("Аттракцион парк");
        amusementPark.addAttraction("Американские горки", "10:00 - 22:00", 300);
        amusementPark.addAttraction("Колесо обозрения", "09:00 - 21:00", 250);
        amusementPark.addAttraction("Лабиринт", "10:00 - 20:00", 150);
        amusementPark.displayAttractions();

    }
}