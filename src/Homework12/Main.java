package Homework12;

public class Main {
    public static void main(String[] args) {
        String[][] correctTwoDimArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] incorrectRowTwoDimArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}};
        String[][] incorrectColumnTwoDimArray = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"10", "11", "12"}};
        String[][] incorrectCharTwoDimArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "двенадцать"}, {"13", "14", "15", "16"}};

        try {
            System.out.println("Вариант 1");
            System.out.println("Сумма всех элементов массива равна " + CheckArray.checkMethod(correctTwoDimArray));
            System.out.println("------------------------------------------------------");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Вариант 2");
            System.out.println("Сумма всех элементов массива равна " + CheckArray.checkMethod(incorrectRowTwoDimArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------");
        }

        try {
            System.out.println("Вариант 3");
            System.out.println("Сумма всех элементов массива равна " + CheckArray.checkMethod(incorrectColumnTwoDimArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------");
        }

        try {
            System.out.println("Вариант 4");
            System.out.println("Сумма всех элементов массива равна " + CheckArray.checkMethod(incorrectCharTwoDimArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
