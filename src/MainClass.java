import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        boolean isAmountWithin = amountWithin(10, 11);
        System.out.println(isAmountWithin);
        positiveOrNegative(5);
        boolean isNegative = positiveOrNegative1(0);
        System.out.println(isNegative);
        stringPrintNumberTimes("Лето", 5);
        boolean isLeapYear = leapYearOrNot(2001);
        System.out.println(isLeapYear);
        arrayReplacement();
        fillArrayTo100();
        multiplyNumbersLessThan();
        diagonalWithUnits();
        returnOneDimensionalArray(4, 10);
    }

    static void printThreeWords() {
        System.out.println("\nЗадание 1.");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign() {
        System.out.println("\nЗадание 2.");
        int a = 20;
        int b = -5;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void printColor() {
        System.out.println("\nЗадание 3.");
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        System.out.println("\nЗадание 4.");
        int a = 5;
        int b = 5;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    static boolean amountWithin(int a, int b) {
        System.out.println("\nЗадание 5.");
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    static void positiveOrNegative(int a) {
        System.out.println("\nЗадание 6.");
        if (a >= 0) {
            System.out.println("положительное число");
        } else if (a < 0) {
            System.out.println("отрицательное число");
        }
    }

    static boolean positiveOrNegative1(int a) {
        System.out.println("\nЗадание 7.");
        if (a < 0) {
            return true;
        } else if (a == 0) {
            return false;
        } else {
            return false;
        }
    }

    static void stringPrintNumberTimes(String text, int count) {
        System.out.println("\nЗадание 8.");
        for (int i = 0; i < count; i++)
            System.out.println(text);
    }

    static boolean leapYearOrNot(int year) {
        System.out.println("\nЗадание 9.");
        if (((year % 4) == 0) && !((year % 100) == 0)) {
            return true;
        } else if ((year % 400) == 0) {
            return true;
        } else {
            return false;
        }
    }

    static void arrayReplacement() {
        System.out.println("\nЗадание 10.");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    static void fillArrayTo100() {
        System.out.println("\nЗадание 11.");
        int[] fillArray = new int[100];
        for (int i = 0; i < fillArray.length; i++) {
            fillArray[i] = i + 1;
            System.out.println(fillArray[i] + " ");
        }
    }

    static void multiplyNumbersLessThan() {
        System.out.println("\nЗадание 12.");
        int[] multArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < multArray.length; i++) {
            if (multArray[i] < 6) {
                multArray[i] = multArray[i] * 2;
            }
            System.out.println(multArray[i] + " ");
        }
    }

    static void diagonalWithUnits() {
        System.out.println("\nЗадание 13.");
        int[][] twoDimArray = new int[5][5];
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0, x = twoDimArray[i].length - 1; j < twoDimArray[i].length; j++, x--) {
                if (i == j || i == x) {
                    twoDimArray[i][j] = 1;
                } else {
                    twoDimArray[i][j] = 0;
                }
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void returnOneDimensionalArray(int len, int initialValue) {
        System.out.println("\nЗадание 14.");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            System.out.print(arr[i] + " ");
        }
    }
}





