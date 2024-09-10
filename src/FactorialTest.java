import org.testng.Assert;
import org.testng.annotations.Test;
public class FactorialTest {
    // Тест для обычного случая, где n = 5
    @Test
    public void testFactorialOfFive() {
        int result = Main.factorial(5);
        Assert.assertEquals(result, 120, "Факториал 5 должен быть 120");
    }
    // Тест для случая, где n = 0
    @Test
    public void testFactorialOfZero() {
        int result = Main.factorial(0);
        Assert.assertEquals(result, 1, "Факториал 0 должен быть 1");
    }
    // Тест для случая, где n = 1
    @Test
    public void testFactorialOfOne() {
        int result = Main.factorial(1);
        Assert.assertEquals(result, 1, "Факториал 1 должен быть 1");
    }
    // Тест для случая отрицательного числа (должно бросать исключение)
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Main.factorial(-5);
    }
}
