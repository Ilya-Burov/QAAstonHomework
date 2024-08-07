//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var task1 = new Task1();
        var task2 = new Task2();
        var task3 = new Task3();
        var task4 = new Task4();
        var task5 = new Task5();
        var task6 = new Task6();
        var task7 = new Task7();
        var task8 = new Task8();
        var task9 = new Task9();
        var task10 = new Task10();
        var task11 = new Task11();
        var task12 = new Task12();
        var task13 = new Task13();
        var task14 = new Task14();
        task1.printThreeWords();
        task2.checkSumSign();
        task3.printColor();
        task4.CompareNumbers();
        task5.checkSumBool(15,7);
        task6.checkNumberSign(0);
        task7.checkNumberSignBool(2);
        task8.printManyTimes("Привет",5);
        task9.isLeapYear(2000);
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        task10.inverseMassive(array);
        for(int value: array){
            System.out.println(value + " ");
        }
        int[] array1 = new int[100];
        task11.fillArray(array1);
        for(int value1: array1){
            System.out.print(value1 + " ");
        }
        System.out.println();
        int[] array2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task12.modifyArray(array2);
        for(int value2: array2){
            System.out.print(value2 + " ");
        }
        int[][] matrix = new int[5][5];
        task13.fillDiagonals(matrix);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        var testArray =task14.createarray(3,60);
        for(int value: testArray){
            System.out.print(value + " ");
        }
    }
}