package Homework14;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("0! =  " + FactorialCalculation.getFactorial(0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("1! =  " + FactorialCalculation.getFactorial(1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("12! =  " + FactorialCalculation.getFactorial(12));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("-1! =  " + FactorialCalculation.getFactorial(-1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("3.5! =  " + FactorialCalculation.getFactorial(3.5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
