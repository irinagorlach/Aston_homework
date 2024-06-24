package TestNG;

import Homework14.FactorialCalculation;
import Homework14.IllegalArgumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFactorial {
    @Test(description = "Факториал нуля")
    public void testFactorialOfZero() throws IllegalArgumentException {
        Assert.assertEquals(FactorialCalculation.getFactorial(0), 1);
    }

    @Test(description = "Факториал единицы")
    public void testFactorialOfOne() throws IllegalArgumentException {
        Assert.assertEquals(FactorialCalculation.getFactorial(1), 1);
    }

    @Test(description = "Факториал двенадцати")
    public void testFactorialOfTwelve() throws IllegalArgumentException {
        Assert.assertEquals(FactorialCalculation.getFactorial(12), 479001600);
    }

    @Test(description = "Факториал отрицательного числа")
    public void testFactorialOfNegative() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculation.getFactorial(-1);
        });
    }

    @Test(description = "Факториал дробного числа")
    public void testFactorialFractional() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculation.getFactorial(3.5);
        });
    }
}
