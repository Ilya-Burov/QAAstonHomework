import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число для вычисления факториала: ");
        try {
            int number = scanner.nextInt();
            long factorial = factorial(number);
            System.out.println("Факториал числа " + number + " равен " + factorial);
        } catch (IllegalArgumentException e) {
            // Обрабатываем исключение при отрицательном числе
            System.out.println("Ошибка: " + e.getMessage());
        } catch (InputMismatchException e) {
            // Обрабатываем исключение при вводе дробного числа или текста
            System.out.println("Ошибка: Введено не целое число. Пожалуйста, введите целое число.");
        }
    }

    public static int factorial(int n) {
        if (n < 0) {
            // Выбрасываем исключение, если число отрицательное
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}