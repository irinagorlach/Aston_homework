package TestJUnit5;

import Homework14.FactorialCalculation;
import Homework14.IllegalArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestFactorial {
    @Test
    @DisplayName("Факториал нуля")
    public void testFactorialOfZero() throws IllegalArgumentException {
        Assertions.assertEquals(1, FactorialCalculation.getFactorial(0));
    }

    @Test
    @DisplayName("Факториал единицы")
    public void testFactorialOfOne() throws IllegalArgumentException {
        Assertions.assertEquals(1, FactorialCalculation.getFactorial(1));
    }

    @Test
    @DisplayName("Факториал двенадцати")
    public void testFactorialOfTwelve() throws IllegalArgumentException {
        Assertions.assertEquals(479001600, FactorialCalculation.getFactorial(12));
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    public void testFactorialOfNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculation.getFactorial(-1);
        });
    }

    @Test
    @DisplayName("Факториал дробного числа")
    public void testFactorialFractional() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculation.getFactorial(3.5);
        });
    }
}
