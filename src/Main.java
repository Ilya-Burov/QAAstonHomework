public class Main {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер всего массива
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4.");
        }
        // Проверяем длину каждой строки массива
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Каждая строка массива должна содержать 4 элемента.");
            }
        }
        int sum = 0;
        // Проходим по массиву и пытаемся конвертировать каждый элемент в int
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Некорректные данные в ячейке: [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        // Корректный массив
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        // Массив с неверным размером
        String[][] invalidSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11"},
                {"13", "14", "15", "16"}
        };
        // Массив с некорректными данными
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "X", "16"}
        };
        // Проверка с корректным массивом
        try {
            System.out.println("Сумма для корректного массива: " + processArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        // Проверка с массивом неверного размера
        try {
            System.out.println("Сумма для массива с неверным размером: " + processArray(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        // Проверка с массивом с некорректными данными
        try {
            System.out.println("Сумма для массива с некорректными данными: " + processArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}