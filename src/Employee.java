import java.io.Console;

public class Employee {
    private String FIO;
    private String post;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;
    Employee(String FIO, String post, String Email, String phoneNumber, int salary, int age){
        this.FIO = FIO;
        this.post = post;
        this.email = Email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
    void printConsole(){
        System.out.println("ФИО:" + FIO + " Должность:"+ post + " email:" + email);
        System.out.println( " Номер телефона:" + phoneNumber + " Зарплата:" + salary + " Возраст:" + age);
    }
}
