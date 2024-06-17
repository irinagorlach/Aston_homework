package Homework12;

public class CheckArray {
    public static int checkMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть 4-х строчным, а он " + array.length + "-х строчный");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть 4-х столбцовым, а он " + array[i].length + "-х столбцовый");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неправильные значения в ячейке (" + i + "," + j + "): ");
                }
            }
        }
        return sum;
    }
}



