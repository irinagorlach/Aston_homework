package Homework14;

public class FactorialCalculation {
    public static long getFactorial(double n) throws IllegalArgumentException {
        if (n < 0 || n != Math.floor(n)) {
            throw new IllegalArgumentException("Число не может быть отрицательным или дробным.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
