public class Task10 {
    void inverseMassive(int[] array){

        for(int i = 0; i < array.length;i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }
}


