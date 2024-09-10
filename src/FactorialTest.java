import org.junit.jupiter.api.Test;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
public class FactorialTest {
    @Test
    public void testFactorialPositiveNumber() {
        // Тестирование вычисления факториала положительного числа
        assertEquals(120, Main.factorial(5), "Факториал 5 должен быть 120");
    }
    @Test
    public void testFactorialZero() {
        // Тестирование вычисления факториала для числа 0
        assertEquals(1, Main.factorial(0), "Факториал 0 должен быть 1");
    }
    @Test
    public void testFactorialOne() {
        // Тестирование вычисления факториала для числа 1
        assertEquals(1, Main.factorial(1), "Факториал 1 должен быть 1");
    }
    @Test
    public void testFactorialNegativeNumber() {
        // Тестирование выброса исключения при вводе отрицательного числа
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Main.factorial(-5),
                "Число должно быть неотрицательным"
        );
        assertEquals("Число должно быть неотрицательным", exception.getMessage());
    }
    @Test
    public void testFactorialNonIntegerInput() {
        // Тестируем выброс InputMismatchException при вводе нецелого числа через Scanner
        InputMismatchException exception = assertThrows(
                InputMismatchException.class,
                () -> {
                    Scanner scanner = new Scanner("5.5");
                    scanner.nextInt();  // Попытка ввести дробное число вызовет исключение
                },
                "Ожидалось исключение InputMismatchException при вводе дробного числа"
        );
    }

}
